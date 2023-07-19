<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>***EmployeeForm***</title>
</head>
<body>
<div align="center">
<h1>Employee Management Form</h1>

<f:form action="saveEmployee" method="post" modelAttribute="employee">
<table>

<tr>
<td>Emp Id:</td>
<td><f:input type="text"  name="empId" path="empId" /></td>
<td><f:errors  path="empId" /></td>
</tr>

<tr>
<td>Name:</td>
<td><f:input type="text"  name="name"  path="name" /></td>
<td><f:errors  path="name" /></td>
</tr>

<tr>
<td>Designation:</td>
<td><f:input type="text"  path="designation" /></td>
<td><f:errors  path="designation" /></td>
</tr>


<tr>
<td>Salary:</td>
<td><f:input type="text"  path="salary" /></td>
<td><f:errors  path="salary" /></td>
</tr>

<tr>
<td>Date of Birth:</td>
<td><f:input type="date"  name="dob"  path="dob" /></td> 
</tr>

<tr>
<td>Gender:</td>
<td><f:radiobuttons name="gender"   path="gender" items="${genders}"/></td>
<td><f:errors path="gender" /></td>
</tr>

<tr>
<td>Citizenship:</td>
<td>
<f:radiobutton name="citizenship"   path="citizenship"  value="USA" label="USA"/>
<f:radiobutton name="citizenship"   path="citizenship"  value="India" label="India"/>
<f:radiobutton name="citizenship"   path="citizenship"  value="France" label="France"/>
<f:radiobutton name="citizenship"   path="citizenship"  value="UK" label="UK"/>
<f:radiobutton name="citizenship"   path="citizenship"  value="Germany" label="Germany"/>
<f:radiobutton name="citizenship"   path="citizenship"  value="China" label="China"/>

</td>
<td><f:errors path="citizenship" /></td>
</tr>

<tr>
<td>Hobbies:</td>
<td><f:checkboxes name="hobbies"   path="hobbies"  items="${hobbies}"/></td>
<td><f:errors path="hobbies" /></td>
</tr>	

<tr>
<td>Spoken Languages:</td>
<c:forEach items="${spokenLanguages}" var="sl"> 
<td><f:checkbox  path="spokenLanguages" value="${sl}" label="${sl}"/></td>

</c:forEach>
<td><f:errors path="spokenLanguages" /></td>
</tr>	
	
<tr>
<td>Skills:</td>
<td>
<f:select  path="skills" >
<f:option value="" label="Please select a vlaue"></f:option>
<f:options items="${skills}"/>
</f:select>
</td>
<td><f:errors path="skills" /></td>
</tr>		

<tr>
<td>Insured ?:</td>
<td>
<c:choose>
<c:when test="${isInsured}">
	<f:checkbox path="insured"  checked="checked"/>
</c:when>
<c:otherwise>
	<f:checkbox path="insured" />
</c:otherwise>


</c:choose>
</td>
<td><f:errors path="insured" /></td>
</tr>	

<tr>
<td>Phone Number:</td>
<td><f:input type="text"   path="phoneNumber" /></td>
<td><f:errors path="phoneNumber" /></td>
</tr>	


<tr>
<td>Email:</td>
<td><f:input type="text"  path="email" /></td>
<td><f:errors path="email" /></td>
</tr>	

<tr>
<td colspan="3" align="center"><strong>Address</strong></td>
</tr>

<tr>
<td>Address Line1:</td>
<td><f:input type="text"  path="address.addressLine1" /></td>
<td><f:errors path="address.addressLine1" /></td>
</tr>	

<tr>
<td>Address Line2:</td>
<td><f:input type="text"  path="address.addressLine2" /></td>
<td><f:errors path="address.addressLine2" /></td>
</tr>

<tr>
<td>City:</td>
<td><f:input type="text"  path="address.city" /></td>
<td><f:errors path="address.city" /></td>
</tr>

<tr>
<td>State:</td>
<td><f:input type="text"  path="address.state" /></td>
<td><f:errors path="address.state" /></td>
</tr>

<tr>
<td>Country:</td>
<td><f:input type="text"  path="address.country" /></td>
<td><f:errors path="address.country" /></td>
</tr>

<tr>
<td colspan="2" align="center"><input type="submit"  value="Submit" /></td>
</tr>

</table>
</f:form>

<c:if test="${not empty employees }">
<table border="1">
<thead>
<tr>
<th>EmpId</th><th>Name</th><th>Designation</th><th>Salary</th>
<th>Gender</th>
<th>Citizenship</th>
<th>Hobbies</th>
<th>Spoken Languages</th>
<th>Skills</th>
<th>Insured</th>
<th>Phone Number</th>
<th>Email</th>
<th>City</th>
<th>Action</th>
</tr>
</thead>
<c:forEach items="${employees}" var="e">
	<tr>
		<td>${e.empId}</td>
		<td>${e.name}</td>
		<td>${e.designation}</td>
		<td>${e.salary}</td>
		<td>${e.gender}</td>
		<td>${e.citizenship}</td>
		<td>
		<c:forEach items="${e.hobbies}" var="hobby">
		${hobby}&nbsp;
		</c:forEach>
		</td>
		<td>
		<c:forEach items="${e.spokenLanguages}" var="sl">
		   ${sl}
		</c:forEach>
		</td>
	
	<td>
	<c:forEach items="${e.skills}" var="skill">
		${skill}
	</c:forEach>
	</td>
	
	
	<td>${e.insured}</td>
	<td>${e.phoneNumber}</td>
	<td>${e.email}</td>
	<td>${e.address.city},${e.address.state}</td>
		<td><a href="delete?empId=${e.empId}">Delete</a> | <a href="update?empId=${e.empId}">Update</a></td>
	</tr>
</c:forEach>
</table>
</c:if>

</div>
</body>
</html>