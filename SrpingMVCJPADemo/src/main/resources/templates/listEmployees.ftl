<!DOCTYPE html>
<html>
<head>
<title>Employee Entry</title>
<link href="css/style.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<header>
			<h1>
				<span>Employee </span>
			</h1>
		</header>
		<div>
			<a href="viewEmp?id=0&e=save" >Add new employee </a>
			<table id="employees">
				<tr>
					<th>Name</th>
					<th>Address</th>
					<th>Email</th>
					<th>Phone</th>
					<th colspan=2>Action</th>
				</tr>
				<#if empList??>
					<#list empList as employ>
					<#if employ??>
					<tr>
						<td><#if employ.name??> ${employ.name} </#if></td>
						<td><#if employ.address??> ${employ.address} </#if></td>
						<td><#if employ.email??> ${employ.email} </#if></td>
						<td><#if employ.telephone??> ${employ.telephone} </#if></td>
						<td><a href="viewEmp?id=${employ.id}&e=modify" >Edit </a></td>
						<td><a href="viewEmp?id=${employ.id}&e=delete" >Delete </a></td>
					<tr>
					</#if>
					</#list>
				</#if>
			</table>

		</div>
	</div>

</body>
</html>
