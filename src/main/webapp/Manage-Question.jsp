<%@page import="java.lang.reflect.InvocationTargetException"%>
<%@page import="com.helper.*"%>
<%@page import="com.entity.*"%>
<%@page import="javax.servlet.http.Part"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
DatabaseClass DAO = new DatabaseClass();
/* String id = (String) session.getAttribute("UserId"); */
String eexam = request.getParameter("eexam");
String eexamid = request.getParameter("eexamid");
String sexamid = request.getParameter("sexamid");
String delques = request.getParameter("delques");

%>
<%if(session.getAttribute("UserStatus")!=null){
	if(session.getAttribute("UserStatus").equals("1")){ 
		String id = (String) session.getAttribute("UserId");
 		User user1=DAO.getUserDetails(id);
%>
	 <!-- --------------------------main body ---------------------------------------------->
	<div class="main-body">
		<div class="main-containt">
			<div class="small-containers">
                <div class="dash-board container-padding">
                    <div class="flex-div-center">
                        
                        <span>Questions</span>
                    </div>
                    <a href="">Today is
                        <span id="day">day</span>,
                        <span id="daynum">00</span>
                        <span id="month">month</span>
                        <span id="year">0000</span>
                        <span class="display-time"></span>
                    </a>
                </div>
                <hr>
            </div>
<!-- ==========================================Profile Edit============================ -->
       		<jsp:include page="EditUserProfile.jsp" /> 
<!--  /*=============================Delete Exam========================================  */ -->
			<%
			if (request.getParameter("delquesid")!=null&&request.getParameter("delques")!=null) {
				String delquesid = request.getParameter("delquesid");
				DAO.deleteques(delquesid);
			}   
			%>
<!-- ==========================================Add Exam============================ -->	

  			<div class="small-containers batchlist" id="batchlist">
                 <div class="student-containt container-padding ">
                    <div><i class="fa fa-list" aria-hidden="true"></i>
                        <span>Question List</span>
                    </div>
                    <div>
                        <select name="batch-dropdown" class="batch-dropdown" id="batch" onchange="location = this.value;">
                            <option value="---">Select Exam</option>
                        <% 
                        int i=0;
						List<Exam> Listexam = DAO.getAllexam(id);
						for(Exam exam : Listexam) {
						%>
                            <option value="User-Page.jsp?pg=4&sques=1&sexamid=<%=exam.getExamid()%>">
                            	<%=exam.getExamtitle()%>
                            </option>
                         <%i++;%>
                        <%} %>      
                        </select>
                    </div>
                </div>
                <hr>
                <div class="queslist ">
                    <%
                        if (request.getParameter("sexamid") != null) {
                            List<Question> listques = DAO.getexamquestion(sexamid);
                            Exam exam = DAO.getexamDetails(sexamid);
                            request.setAttribute("listques", listques);
                            request.setAttribute("exam", exam);
                        }
                    %>
                    <table >
                        <tr>
                        	<th style="width:5%">Sr. No.</th>
                        	<th style="width:10%">Exam Name</th>
                            <th>Question</th>
                            <th>Option 1</th>
                            <th>Option 2</th>
                            <th>Option 3</th>  
                            <th>Option 4</th>
                            <th>Answer</th>
                            <th style="width:7%">Delete</th>
                        </tr>

                        <c:if test="${not empty listques}">
                            <c:forEach var="ques" items="${listques}" varStatus="loop">
                                <tr>
                                    <td>${loop.index + 1}</td>
                                    <td><c:out value="${exam.examtitle}" /></td>
                                    <td>
                                        <pre style="white-space: pre-wrap; font-family: monospace;">
                                            <c:out value="${ques.ques}" />
                                        </pre>
                                    </td>
                                    <td><c:out value="${ques.optn1}" /></td>
                                    <td><c:out value="${ques.optn2}" /></td>
                                    <td><c:out value="${ques.optn3}" /></td>
                                    <td><c:out value="${ques.optn4}" /></td>
                                    <td><c:out value="${ques.ans}" /></td>
                                    <td>
                                        <a href="User-Page.jsp?pg=4&delques=1&delquesid=${ques.quesid}">
                                            <span style="color: red;" class="material-symbols-outlined">delete_forever</span>
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </c:if>

                        <c:if test="${empty listques}">
                            <tr>
                                <td colspan="9">----------Select Exam----------</td>
                            </tr>
                        </c:if>
                    </table> 
                </div>
                <hr>
            </div>
		</div>
	</div>
	     <%
		}else{
			response.sendRedirect("index.jsp");
		}
	}else{
		response.sendRedirect("index.jsp");
	}

	%>