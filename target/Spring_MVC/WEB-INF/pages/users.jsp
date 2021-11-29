<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Аркадий
  Date: 29.11.2021
  Time: 17:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
<a href="../../index.jsp">Back to main menu</a>
<br/>
<br/>
<h3>Users Base</h3>

<c:if test="${!empty listUsers}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">Name</th>
            <th width="120">Gender</th>
            <th width="120">Age</th>
            <th width="60">Edit</th>
            <th width="60"> Delete</th>
        </tr>
        <c:forEach items="${listUsers}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.gender}</td>
                <td>${user.age}</td>
                <td><a href="<c:url var="/edit/${user.id}"/>">">Edit</a></td>
                <td><a href="<c:url var="/delete/${user.id}"/>">">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<h1>Add User</h1>

<c:url var="addAction" value="/users/save">
    <form:form action="${addAction}" commandName="user">
        <table>
            <c:if test="${!empty user.userName}">
                <tr>
                    <td>
                        <form:label path="id">
                            <spring:message var="ID"/>
                        </form:label>
                    </td>
                    <td>
                        <form:input path="id" readonly="true" size="8" disabled="true"/>
                        <form:hidden path="id"/>
                    </td>
                </tr>
            </c:if>
            <tr>
            <td>
                <form:label path="name">
                    <spring:message var="Name"/>
                </form:label>
            </td>
            <td>
                <form:input path="name"/>
            </td>
            </tr>
            <tr>
                <td>
                    <form:label path="gender">
                        <spring:message var="Gender"/>
                    </form:label>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="age">
                        <spring:message var="Age"/>
                    </form:label>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <c:if test="${!empty user.name}">
                        <input type="submit" value="<spring:message var="Edit User"/>"/>
                    </c:if>
                    <c:if test="${empty user.name}">
                        <input type="submit" value="<spring:message var="Save User"/> "/>
                    </c:if>
                </td>
            </tr>

        </table>

    </form:form>
</c:url>
<br/>
<br/>
</body>
</html>
