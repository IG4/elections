<%@ page contentType="text/html; charset=ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<body>
	<table border="1">
		<s:iterator value="electeurs">
			<tr>
				<td><s:property value="prenom" /></td>
				<td><s:property value="nom" /></td>

			</tr>
		</s:iterator>
	</table>
</body>
</html>
