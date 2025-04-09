/**
 * event.js
 */

document.addEventListener('DOMContentLoaded', async function() {
   let events = [];
   await fetch(`eventList.do`)
      .then( result => result.json() )
      .then( result => {
         events = result.map(ev => {
			return {
				title: ev.TITLE,
				start: ev.START_DATE,
				end: ev.END_DATE
			};
		 });
      }).catch( err => console.log(err) );
   createCalendar(events);
});
 
function createCalendar(events) {
   var calendarEl = document.getElementById('calendar');
   console.log(events);
   var calendar = new FullCalendar.Calendar(calendarEl, {
      headerToolbar: {
         left: 'prev,next today',
         center: 'title',
         right: 'dayGridMonth,timeGridWeek,timeGridDay'
      },
      initialDate: '2025-04-09',
      navLinks: true, // can click day/week names to navigate views
      selectable: true,
      selectMirror: true,
      select: async function(arg) {
         var title = prompt('Event Title:');
         if (title) {
			let code;
            await fetch(`existEvent.do?title=${title}&start=${arg.startStr}&end=${arg.endStr}`)
               .then( result => result.json() )
               .then( result => {
                  code = result.retCode;
                  if (result.retCode == 'exist') {
                     alert("해당일정이 존재합니다.");
                  }
               }).catch( err => console.log(err) );
               console.log(code);
            if (code != 'exist') {
               await fetch(`addEvent.do?title=${title}&start=${arg.startStr}&end=${arg.endStr}`)
                  .then( result => result.json() )
                  .then( result => {
                     if (result.retVal == "OK")
                        alert("추가성공")
                  }).catch( err => console.log(err) );

               calendar.addEvent({
                  title: title,
                  start: arg.start,
                  end: arg.end,
                  allDay: arg.allDay
               })
            }
         }
         calendar.unselect();
      },
      eventClick: function(arg) {
         if (confirm('Are you sure you want to delete this event?')) {
            fetch(`removeEvent.do?title=${arg.event.title}&start=${arg.event.startStr}&end=${arg.event.endStr}`)
               .then( result => result.json() )
               .then( result => {
                  if (result.retVal == "OK")
                     alert("삭제성공")
               }).catch( err => console.log(err) );
            arg.event.remove();
         }
      },
      editable: true,
      dayMaxEvents: true, // allow "more" link when too many events
      events: events
   });

   calendar.render();
}