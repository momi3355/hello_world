/**
 * boardService.js
 */

const svc = {
   id: "ReplyService",
   //목록
   replyList: (search = {bno, page}, successCallback, errorCallback) => {
      fetch(`replyList.do?bno=${search.bno}&page=${search.page}`)
         .then(result => result.json())
         .then(successCallback)
         .catch(errorCallback);
   },
   //페이지 계산
   pagingList: (bno=100, successCallback, errorCallback) => {
      fetch(`replyCount.do?bno=${bno}`)
         .then(result => result.json())
         .then(successCallback)
         .catch(errorCallback);
   },
   //추가
   addReply: (rvo = {bno, reply, replyer}, successCallback, errorCallback) => {
      fetch(`addReply.do?bno=${rvo.bno}&replyer=${rvo.replyer}&reply=${rvo.reply}`)
         .then(result => result.json())
         .then(successCallback)
         .catch(errorCallback);
   },
   //삭제
   removeReply: (rno, successCallback, errorCallback) => {
      fetch(`removeReply.do?rno=${rno}`)
         .then(result => result.json())
         .then(successCallback)
         .catch(errorCallback);
   }
};