/delim {  }
/var pfile_ help/poem.300
/var qfile_ poem.q
/var errfile_ poem.err

showg $_clock
/al afterPoem showg $_clock

/al poem1 {/if {[%%1=]}{/var f @fopen{$qfile_ r};/fgets lineq 100 $f;/fclose $f} else {/var lineq %%1};/if {[%%2=]}{/var option_ 0} else {/var option_ %%2};/var f @fopen{$pfile_ r};/math l0_ @strlen{$lineq};/var more_ 1;/var Match_ 0;poem2}

/al poem2 {/if {$more_}{/if {!$Match_}{/var more_ @fgets{line $f};chomp line;/var long_ 0;/if {$option_=0 && @strlen{$line}*2>3*$l0_}{/if {@getl{$line}==2}{/var long_ 1;/geti line1 1 $line;/geti line 0 $line}};poem3;/if {$long_}{/var line $line1;poem3};/sleep 0;poem2}} else {dunno;/fclose $f;/sysecho $lineq >> $errfile_;afterPoem}}
/al poem3 {/if {(@strlen{$line})>=($l0_-1)}{/var temp $line;/var match_ 1;/math l1_ $l0_/2-1;/loop {0,$l1_}{/math i %0*2;/if {$match_}{/math l @strlen{$temp}/2-1;/var match_ 0;/loop {0,$l}{/math j %0*2;/if {!$match_}{/if {[@substr{$temp $j 2}=@substr{$lineq $i 2}]}{/var match_ 1;/var temp {@substr{$temp 0 $j}@substr{$temp $j+2 @strlen{$temp}-$j-2}}} else {/var match_ 0}} }}};/if {$match_}{/var Match_ 1;answer $line;/fclose $f;afterPoem} }}
