<#import "lib/fragments.ftl" as f>
<@f.pageTop/>
<span><@s.fielderror/></span>
<@s.form>
<@s.textfield name="bean.text" value="${bean.text}" label="Text:"/>
<@s.submit name="submitValue" value="Add"/>
<@s.submit name="submitValue" value="Cancel"/>
</@s.form>
<@f.pageBottom/>
