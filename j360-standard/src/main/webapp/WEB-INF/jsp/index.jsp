<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">

<body>
<table>
	<thead>
	<tr>
		<td>Title</td>
		<td>Body</td>
		<td>Tags</td>
	</tr>
	</thead>
	<tbody>
	<c:forEach items="${notes}" var="note">

		<tr>
			<td>${note.title}</td>
			<td>${note.body}</td>
			<td>
				<c:forEach items="${note.tags}" var="tag">
					<span>${tag.name}</span>
				</c:forEach>
			</td>
		</tr>
	</c:forEach>

	</#list>
	</tbody>
</table>
</body>

</html>
