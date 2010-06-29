/var fname data/$name.data
/var f @fopen{$fname r}
/var f2 @fopen{temp w}
/al doline {/loop {0,$n}{/var i %0;/geti item $i $slist;/math $item ${$item};/if {${$item}}{/strstr {$line} {/var $item };/if {$_=0}{/var line {/var $item ${$item}$nl}}}}}
/al doread {/fgets line 2048 $f;/if {$_}{doline;/fputs {$line} $f2;/sleep 0;doread} else {/fclose $f;/fclose $f2;/if {$_=0}{/remove $fname;/rename temp $fname}}}

/var slist {force forcea spell spella}
/delim { }
/math n @getl{$slist}-1
/chr nl 10
/var more 1;doread
