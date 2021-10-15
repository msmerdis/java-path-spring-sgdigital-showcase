<#import  "partial/siteTemplate.ftl" as siteTemplate>
<head>
    <@siteTemplate.importantLibraries/>
</head>
<body>
<@siteTemplate.navbar currentPage="findYourProduct"/>
Get:
<form method="get" action="/mvc/findYourProduct">
	<input type="number" name="productIndex" id="productIndex">
	<input type="submit">
</form>
Post:
<form method="post" action="/mvc/findYourProduct">
	<input type="number" name="productIndex" id="productIndex">
	<input type="submit">
</form>

<#if product??>
<p>${product}</p>
</#if>
<@siteTemplate.footer/>
</body>
