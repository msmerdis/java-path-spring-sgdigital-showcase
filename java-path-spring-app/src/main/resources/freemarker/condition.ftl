<html>
<head></head>
<body>
<#if result>
	<p>Hello from FreeMarker</p>
<#else>
	<p>Not Hello.</p>
</#if>
<#if product??>
	<p>Product exists</p>
<#else>
	<p>Product does not exist</p>
</#if>


</body>
</html>
