/var tune 0
/var cure 0
/al Cf2 {chk {/math maxqi $Qix;/if {[%%%0!=]}{/math maxqi %%%0};/if {$qi>$maxqi}{/math qi $maxqi};/if {$qi>9}{/if {$qi>$qix}{/math qi $qix};cf2 $qi;/var qi};/if {$qi<10 && $tune<1}{/al Cf2act /nop;/al Cf2act %%%0;Cf2act};/if {$qi<10 && $tune>0}{/if {$neiqi>19}{/if {$tune=0 || $neiqi+1>$tune}{f2}};/if {$neiqi<$tune || $neiqi<20}{att 0}}}}
/al CF2 {chk {/if {$qix>9}{/if {$Qi>9}{/if {$Qi<$qix}{cf2 $Qi} else {cf2 $qix}} else {cf2 10}} } }
/al Cf3 {chk {/if {$sh>9}{/if {$sh>$shen}{/math sh $shen};cf3 $sh;/var sh};/if {$sh<10 && $tune<1}{/al Cf3act /nop;/al Cf3act %%%0;Cf3act};/if {$sh<10 && $tune>0}{/if {$neish>19}{/if {$tune=0 || $neish+1>$tune}{f3}};/if {$neish<$tune || $neish<20}{/if {$tune=0}{att 0} else {att 1}}}}}
/al CF3 {chk {/if {$shen>9}{/if {$Sh>9}{/if {$Sh<$shen}{cf3 $Sh} else {cf3 $shen}} else {/al CF3act /nop;/al CF3act %%%%0;CF3act}} } }
/al cureAct f4
/al att {/math tune %0;/if {%%0>0}{Cf2;/al finishcf2 {hp;/sleep 3;f2;Cf2}};/if {%%0=0}{/al finishcf2 /nop;/al finishcf3 /nop;finisht} }
/al att3 {/math tune %0;/if {%%0>0}{Cf3;/al finishcf3 {/sleep 3;f3;Cf3};/al finishcf2 {/sleep 3;f2;Cf2}};/if {%%0=0}{finisht} }
/al att1 {/math tune %0;/if {%%0>0}{F1;auto 1;/act {Äã×øÏÂ} {Cf2};/act {ÄãÉîÉî} {Cf2};/act {×îÉÙÓÃ¶şÊ®}{Cf2} };/if {%%0=0}{att 0} }
/al atc3 {/math tune %0;/if {%%0>0}{F3;auto 1;/act {ÄãÂÔÒ»}{atc %%%0};/act {×îÉÙÓÃ¶şÊ®}{atc %%%0} };/if {%%0=0}{att 0} }

/al finishtold {/bell;/show {[1;32m£Ô£õ£î£å£ä£ß£õ£ğ£¡[2;37;0m}}
/al finisht finishtold
/al {Finisht %0} {/al finisht0 %0;/al finisht {finisht0;/al finisht finishtold}}
