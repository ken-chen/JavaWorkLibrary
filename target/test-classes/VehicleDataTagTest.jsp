<%@ taglib prefix="cs" uri="futuretense_cs/ftcs1_0.tld"
%><%@ taglib prefix="asset" uri="futuretense_cs/asset.tld"
%><%@ taglib prefix="assetset" uri="futuretense_cs/assetset.tld"
%><%@ taglib prefix="commercecontext" uri="futuretense_cs/commercecontext.tld"
%><%@ taglib prefix="ics" uri="futuretense_cs/ics.tld"
%><%@ taglib prefix="listobject" uri="futuretense_cs/listobject.tld"
%><%@ taglib prefix="render" uri="futuretense_cs/render.tld"
%><%@ taglib prefix="searchstate" uri="futuretense_cs/searchstate.tld"
%><%@ taglib prefix="siteplan" uri="futuretense_cs/siteplan.tld"
%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" 
%><%@ taglib prefix="vehicledata" uri="http://www.holden.com.au/tags/vehicledata"
%><%@ page import="COM.FutureTense.Interfaces.*,
                   COM.FutureTense.Util.ftMessage,
                   COM.FutureTense.Util.ftErrors"
%><cs:ftcs><%-- Tools/VehicleDataTagTest

INPUT

OUTPUT

--%>
<%-- Record dependencies for the SiteEntry and the CSElement --%>
<ics:if condition='<%=ics.GetVar("seid")!=null%>'><ics:then><render:logdep cid='<%=ics.GetVar("seid")%>' c="SiteEntry"/></ics:then></ics:if>
<ics:if condition='<%=ics.GetVar("eid")!=null%>'><ics:then><render:logdep cid='<%=ics.GetVar("eid")%>' c="CSElement"/></ics:then></ics:if>
<vehicledata:loadmodelcolours var="colours" modelId="1236926529414" />
<vehicledata:loadmodeltrims var="trims" modelId="1236926529414" /> 

<h3>Colours: </h3>
<c:forEach items="${colours}" var="colour">
	id is: ${colour.id}
	<br />
	name is: ${colour.name}
	<br />
	colour code is: #${colour.cssColourClass}
	<br />
	<br />
</c:forEach>
   <br />


<%-- 
<h3>Trims: </h3>
<c:forEach items="${trims}" var="trim">
        
    <c:if test="${!empty trim.class.declaredFields}">
		<c:forEach items="${trim.class.declaredFields}" var="trimattr">
		    ${trimattr.name}: ${trim[trimattr.name]}<br />
		</c:forEach>
	</c:if>
	<br />
</c:forEach>
--%>



</cs:ftcs>