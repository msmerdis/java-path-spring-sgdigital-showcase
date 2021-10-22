<#import "/spring.ftl" as spring />
<#import  "partial/siteTemplate.ftl" as siteTemplate>
<head>
	<@siteTemplate.importantLibraries/>
</head>
<body>
<@siteTemplate.navbar currentPage="registerProduct"/>
<br>
<form method="POST" action="">
	<label>Serial</label>
	<@spring.bind "productForm.serial"/>
	<input type="text" name="serial" value="${productForm.serial!}">
	<#list spring.status.errorMessages as error>
		<p>${error}</p>
	</#list>
	<br>
	<label>Name</label>
    <@spring.bind "productForm.name"/>
	<input type="text" name="name" value="${productForm.name!}">
    <#list spring.status.errorMessages as error>
		<p>${error}</p>
    </#list>
	<br>
	<label>Price</label>
    <@spring.bind "productForm.price"/>
	<input type="number" name="price" value="${productForm.price!}">
    <#list spring.status.errorMessages as error>
		<p>${error}</p>
    </#list>
	<br>
	<label>Category</label>
    <@spring.bind "productForm.category"/>
	<input type="text" name="category" value="${productForm.category!}">
    <#list spring.status.errorMessages as error>
		<p>${error}</p>
    </#list>
	<br>
	<input type="submit">
</form>


<@siteTemplate.footer/>
</body>
