<%--
  Created by IntelliJ IDEA.
  User: KW
  Date: 2022-01-14
  Time: 오후 4:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="../include/header.jsp" %>
<fieldset id="view">
    <input type="hidden" id="idx" value="${board.id}">
    <div id="title-area"><h3 class="view-title">${board.title}<br></h3><span id="writer">${board.writer}</span><span
            style="font-size: 20px;"> &middot; </span><span class="view-date">${board.bdDate}</span></div>
    <pre id="view-area">${board.content}</pre>
    <div class="view">
        <c:if test="${sessionScope.user.userId == board.userId}">
            <input type="button" value="수정하기" onclick="location.href = '/updateForm?id=${board.id}'"/>
        </c:if>
        <input type="button" value="목록" onclick="location.href= '/list';"/>
    </div>
    <c:choose>
        <c:when test="${sessionScope.user != null}">
            <form style="width: 600px; height: 50px; margin: 80px auto 0 auto;" id="commentForm"
                  onsubmit="return false">
                <textarea type="text" placeholder="댓글 입력..." id="comment"
                          style="width: 500px; height: 100%; outline: none; border: 1px solid #ddd; box-sizing: border-box; resize: none; float:  left;"></textarea>
                <input type="button" value="댓글 등록" style="width: 100px; height: 50px; box-sizing: border-box;"
                       onclick="$.commentCreate()">
            </form>
        </c:when>
        <c:otherwise>
            <form style="width: 600px; height: 50px; margin: 80px auto 0 auto;" onsubmit="return false">
                <textarea type="text" placeholder="로그인한 사용자만 댓글을 작성할 수 있습니다."
                          style="width: 500px; height: 100%; outline: none; border: 1px solid #ddd; box-sizing: border-box; resize: none; float:  left;"
                          disabled></textarea>
                <input type="button" value="댓글 등록" style="width: 100px; height: 50px; box-sizing: border-box;" disabled>
            </form>
        </c:otherwise>
    </c:choose>

    <div id="comment-area">
        <ul>
<%--            <c:forEach items="${comment}" var="comment">--%>
<%--                <li class="comment">--%>
<%--                    <p>--%>
<%--                        <input type="hidden" class="comment_idx" value="${comment.idx}">--%>
<%--                        <span class="comment_writer">${comment.writer}</span>--%>
<%--                        <span class="comment_date">${comment.commentDate}</span>--%>
<%--                    </p>--%>
<%--                    <pre--%>
<%--                         class="comment_text">${comment.comment}</pre>--%>
<%--                    <c:if test="${sessionScope.user != null}">--%>
<%--                        <div style="width: 100%; height: 30px;" class="btn_area">--%>
<%--                            <c:if test="${comment.userId == sessionScope.user.userId}">--%>
<%--                                <input type="button" value="삭제" class="del_btn" style="float: right; margin: 0 10px;"--%>
<%--                                       onclick="$.commentDelete(this)">--%>
<%--                                <input type="button" value="수정" class="up_btn"--%>
<%--                                       onclick="$.commentUpdateForm(this)">--%>
<%--                            </c:if>--%>
<%--                            <input type="button" value="답글" class="re_btn" style="float: right;margin-right: 10px;"--%>
<%--                                   onclick="$.replyForm(this)">--%>
<%--                        </div>--%>
<%--                    </c:if>--%>
<%--                    <div class="reply-form">--%>
<%--                        <p><span style="margin: 20px;">${comment.writer} 님께 답글 작성</span></p>--%>
<%--                        <textarea class='reply'></textarea>--%>
<%--                        <div class="btn_area">--%>
<%--                            <input type="button" value="취소" class="cl_btn" onclick="$.replyClose(this)">--%>
<%--                            <input type="button" value="완료" class="cr_btn" onclick="$.replyCreate(this)">--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </li>--%>

<%--                <c:forEach var="reply" items="${reply}">--%>
<%--                    <c:if test="${reply.commentIdx == comment.idx}">--%>
<%--                        <li style="min-height: 100px; border-bottom: 1px solid #ddd;" class="reply"><p>--%>
<%--                            <input type="hidden" class="reply_idx" value="${reply.idx}">--%>
<%--                            <span style="margin-left: 10px;">&#8618;</span>--%>
<%--                            <span style="margin-right: 20px; font-weight: bold;">${reply.writer}</span>--%>
<%--                            <span style="font-size: 14px; color: #999;"><fmt:formatDate value="${reply.reDate}"--%>
<%--                                                                                        pattern="YYYY-MM-DD HH:mm:ss"></fmt:formatDate></span>--%>
<%--                        </p>--%>
<%--                            <pre style="padding-left: 30px; width: 530px; min-height: 50px; word-break: break-all; white-space: normal; margin-top: 20px;"--%>
<%--                                 class="comment">${reply.content}</pre>--%>
<%--                            <c:if test="${sessionScope.user != null}">--%>
<%--                                <div style="width: 100%; height: 30px;" class="btn_area">--%>
<%--                                    <c:if test="${reply.userId == sessionScope.user.userId}">--%>
<%--                                        <input type="button" value="삭제" class="re_del_btn"--%>
<%--                                               style="float: right; margin: 0 10px;"--%>
<%--                                               onclick="">--%>
<%--                                        <input type="button" value="수정" class="re_up_btn" style="float: right;"--%>
<%--                                               onclick="">--%>
<%--                                    </c:if>--%>
<%--                                    <input type="button" value="답글" class="re_btn"--%>
<%--                                           style="float: right;margin-right: 10px;"--%>
<%--                                           onclick="$.replyForm(this)">--%>
<%--                                </div>--%>
<%--                            </c:if>--%>
<%--                            <div style="min-height: 100px; border-top: 1px solid black; display: none;"--%>
<%--                                 class="reply-form">--%>
<%--                                <p><span style="margin: 20px;">${reply.writer} 님께 답글 작성</span></p>--%>
<%--                                <textarea--%>
<%--                                        style='margin-left: 40px; width: 520px; min-height: 50px; margin-top: 20px; word-break: break-all; white-space: normal; resize: none;'--%>
<%--                                        class='reply'></textarea>--%>
<%--                                <div style="width: 100%; height: 30px; line-height: 30px;">--%>
<%--                                    <input type="button" value="취소" class="cl_btn" style="float: right; margin: 0 10px;"--%>
<%--                                           onclick="$.replyClose(this)">--%>
<%--                                    <input type="button" value="완료" class="cr_btn" style="float: right;"--%>
<%--                                           onclick="$.replyCreate(this)">--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                        </li>--%>
<%--                    </c:if>--%>
<%--                </c:forEach>--%>
<%--            </c:forEach>--%>
        </ul>
    </div>
</fieldset>

<%@include file="../include/footer.jsp" %>
</div>
<script>
    document.title = `${board.title}`;
</script>
