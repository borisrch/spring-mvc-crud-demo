<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Save Customer</title>
    <link type="text/css" 
        rel="stylesheet" 
        href="${pageContext.request.contextPath}/resources/css/semantic.min.css"/>
    <link type="text/css" 
        rel="stylesheet" 
        href="${pageContext.request.contextPath}/resources/css/styles.css"/>
  <script
  src="http://code.jquery.com/jquery-3.3.1.min.js"
  integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
  crossorigin="anonymous"></script>
  </head>
  <body>
  	<div id="wrapper"> 
    <div id="header">
        <h2>CRM - Customer Relationship Manager</h2>
    </div>

    <div id="container">
        <h3>Save Customer</h3>
        <form:form action="saveCustomer" modelAttribute="customer" method="POST">
        
        <form:hidden path="id"/>
        
            <table>
                <tr>
                    <td><label>First Name:</label></td>
                    <td><div class="ui input"><form:input path="firstName" name="empty"/></div></td>
                 </tr>
                 <tr>
                    <td><label>Last Name:</label></td>
                    <td><div class="ui input"><form:input path="lastName"/></div></td>
                  </tr>
                  <tr>
                    <td><label>Email:</label></td>
                    <td><div class="ui input"><form:input path="email"/></div></td>
                 </tr>
                 <tr>
                 	<td><label></label></td>
                 	<td>
                 	<div id="button-save">
                 	<input type="submit" value="Save" class="positive ui button"/>
                 	<div style="display:inline;"><a href="${pageContext.request.contextPath}/customer/list">Cancel</a></div>
                 	</div>
                 	</td>
                 	
                 </tr>
               
            </table>
        </form:form>
    </div>

</div>
  </body>
</html>