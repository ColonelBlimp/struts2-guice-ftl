<#import "lib/fragments.ftl" as f>
<@f.pageTop/>
<nav>
  <ul><li><a href="<@s.url action="add"/>" title="Add To List">Add To List</a></li></ul>
</nav>
<table>
<#list textList as elem>
<tr><td>${elem}</td></tr>
</#list>
</table>
<@f.pageBottom/>