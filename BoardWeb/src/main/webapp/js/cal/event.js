/**
 * event.js
 */

document.addEventListener("DOMContentLoaded", async function () {
  let events = [];
  await fetch(`eventList.do`)
    .then((result) => result.json())
    .then((result) => {
      events = result.map((ev) => {
        return {
          title: ev.TITLE,
          start: ev.START_DATE,
          end: ev.END_DATE,
        };
      });
    })
    .catch((err) => console.log(err));
  createCalendar(events);
});

function getDateString() {
  let today = new Date();

  let year = today.getFullYear();
  let month = ("0" + (today.getMonth() + 1)).slice(-2);
  let day = ("0" + today.getDate()).slice(-2);
  return year + "-" + month + "-" + day;
}

async function addEvent(arg, title, calendar) {
  let code = "none";
  let allDay = arg.allDay;
  let start = allDay ? arg.startStr : arg.startStr.substring(0, 19);
  let end = allDay ? arg.endStr : arg.endStr.substring(0, 19);

  //일정있는지 확인
  await fetch("existEvent.do?", {
    method: "POST",
    headers: {
      "Content-Type": "application/x-www-form-urlencoded", //json
    },
    body: `title=${title}&start=${start}&end=${end}`,
  })
    .then((result) => result.json())
    .then((result) => {
      code = result.retCode;
      if (result.retCode == "exist") {
        alert("해당일정이 존재합니다.");
      }
    })
    .catch((err) => console.log(err));
  //console.log(code);
  //같은 일정이 없으면 추가
  if (code == "no") {
    await fetch("addEvent.do", {
      method: "POST",
      headers: {
        "Content-Type": "application/x-www-form-urlencoded",
      },
      body: `title=${title}&start=${start}&end=${end}`,
    })
      .then((result) => result.json())
      .then((result) => {
        if (result.retCode == "OK") {
          calendar.addEvent({
            title: title,
            start: start,
            end: end,
            allDay: arg.allDay,
          });
          alert("추가성공");
        }
      })
      .catch((err) => console.log(err));
  }
}

async function removeEvent(arg) {
  await fetch("removeEvent.do", {
    method: "POST",
    headers: {
      "Content-Type": "application/x-www-form-urlencoded",
    },
    body: `title=${arg.event.title}&start=${arg.event.startStr}&end=${arg.event.endStr}`,
  })
    .then((result) => result.json())
    .then((result) => {
      if (result.retVal == "OK") alert("삭제성공");
    })
    .catch((err) => console.log(err));
}

function createCalendar(events) {
  var calendarEl = document.getElementById("calendar");
  //console.log(events);
  var calendar = new FullCalendar.Calendar(calendarEl, {
    headerToolbar: {
      left: "prev,next today",
      center: "title",
      right: "dayGridMonth,timeGridWeek,timeGridDay",
    },
    initialDate: getDateString(),
    navLinks: true, // can click day/week names to navigate views
    selectable: true,
    selectMirror: true,
    select: async function (arg) {
      var title = prompt("Event Title:");
      if (title) addEvent(arg, title, this);
      calendar.unselect();
    },
    eventClick: function (arg) {
      if (confirm("Are you sure you want to delete this event?")) {
        removeEvent(arg);
        arg.event.remove();
      }
    },
    editable: true,
    dayMaxEvents: true, // allow "more" link when too many events
    events: events,
  });

  calendar.render();
}
