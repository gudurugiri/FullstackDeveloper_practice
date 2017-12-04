 <!DOCTYPE html>
<#assign empName="">
		<#assign empid="">
		<#assign empeEmail="">
		<#assign empPhone="">
		<#assign empAddress="">
		<#assign currentActivity="saveEmployee">
		<#assign currentaction="saveEmployee">
		<#assign fieldDisable="">
			<#if employee ??>
				<#assign empName = employee.name!>
				<#assign empid = employee.id!>
				<#assign empeEmail=employee.email!>
				<#assign empPhone=employee.telephone!>
				<#assign empAddress=employee.address! >
			</#if>
			<#if activity??>
				<#assign currentaction =activity+"Employee">
				<#assign currentActivity =activity?capitalize+" Employee">
				<#if activity ='delete'>
				<#assign fieldDisable="readonly='true'">
				</#if>
			</#if>
<html>
<head>
<title>Employee Entry </title>
<link href="css/style.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<header>
			<h1>
				<span>Employee </span>
			</h1>
		</header>
		<div class="form">
		
			<form id="contactform" action="${currentaction}" name="employee" method="POST">
				<p class="contact">
					<label for="name">Employee Name</label>
				</p>
				<input id="name" name="name" placeholder="First and last name"
					required="" tabindex="1" type="text" value="${empName}" ${fieldDisable}>
								<input name="id" type="hidden" value="${empid}" ${fieldDisable}>
				<p class="contact">
					<label for="email">Email</label>
				</p>
				<input id="email" name="email" placeholder="example@domain.com"
					required="" tabindex="2" type="email" value="${empeEmail}" ${fieldDisable}>

				<p class="contact">
					<label for="username">Address </label>
				</p>
				<input id="username" name="address" placeholder="address"
					required="" tabindex="3" type="text" value="${empAddress}" ${fieldDisable}>

				<p class="contact">
					<label for="phone">Phone</label>
				</p>
				<input id="phone" name="telephone" placeholder="phone number"
					required="" type="text" value="${empPhone}" ${fieldDisable}> 
				<br>
				<br> <input class="buttom" name="submit" id="submit"
					tabindex="5" value="${currentActivity}" type="submit">
			</form>
		</div>
	</div>

</body>
</html>
