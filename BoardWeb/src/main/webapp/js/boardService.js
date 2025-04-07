/**
 * boardService.js
 */

const svc = {
   name: "ReplyService",
   //목록
   replyList: (bno, successCallback, errorCallback) => {
      fetch(`replyList.do?bno=${bno}`)
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