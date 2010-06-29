/al deaddir go void;/nop dead direction
/var quedelay 0.3
/nop /al {cf2} {exercise %0;/al lastact exercise %0;/if {$que=1}{/math que 0;/act {你行功完毕}{/math que 1;/unact {你行功完毕};lastact} }}

/act {你现在不能移动} {/if {$que=1 || $auto=1} {/sleep $quedelay;lastact;/math nact {$nact+1};/nop /if {$nact>40}{/math nact 0}}} {3}
/act {你的动作} {/if {$que=1 || $auto=1} {/sleep $quedelay;lastact;/math nact {$nact+1};/nop /if {$nact>40}{/math nact 0}}} {3}
/act {你现在正忙} {/if {$que=1 || $auto=1} {/sleep $quedelay;lastact;/math nact {$nact+1};/nop /if {$nact>40}{/math nact 0}}} {3}
/act {这个方向} {/if {$que=1} {nextact;/math nact {$nact+1};/nop /if {$nact>40}{/math nact 0}}} {3}
/gag {这个方向}
/var auto 0
/var nact 0
/al auto {/var auto %0;/var nact 0;/if {%%0=1}{/gag {你的动作};/gag {你现在正忙};/gag {你上一}};/if {%%0=0}{/ungag {你的动作};/ungag {你现在正忙};/ungag {你上一}} }
/act {你上一}  {/if {$auto=1}{/sleep $quedelay;lastact;/math nact {$nact+1};/nop /if {$nact>40}{/math nact 0}}} {3}

/math nQue 0
/math NQue 0
/math que 0
/al Queue {/math que 1;/if {$nQue=$NQue-1}{clearQue;/unal queAct*;/math nQue -1;/math que 0;/ungag {你的动作};/ungag {你上一};/ungag {你现在正忙}};/if {$nQue<$NQue-1} {/al nextact {queAct$nQue;Queue};/al lastact deaddir;deaddir;/math nQue {$nQue+1}} }
/al addQue {/if {$NQue=0}{/gag {你的动作};/gag {你上一};/gag {你现在正忙};/unal queAct*;/math nQue -1};/al queAct$NQue %0;/math NQue {$NQue+1}}
/al clearQue {/math NQue 0}
/al clq clearQue;/al aq addQue;/al que Queue;/al rpt {/math rpt %0};/al rp {clq;/$rpt aq %0;aq showg rpt done!;que};/al q Que
/nop Que -- single que
/al Que {clearQue;addQue %0;Queue}

/var nSeq 0;/var NSeq 0
/al endSeqOld {/bell;showg End of sequence!};/al endSeq endSeqOld
/al seq+ {/al seq$NSeq %0;/math NSeq $NSeq+1}
/al clrSeq {/var NSeq 0;/var nSeq 0;/var doSeq 0}
/var doSeq 0
/al doSeq {/if {$doSeq}{/if {$nSeq>$NSeq-1}{endSeq;clrSeq} else {seq$nSeq;/math nSeq $nSeq+1;upTime {/sleep $sleepSeq;doSeq}}} else {showg Seq interruppted at $nSeq/$NSeq!}}
/al seq {/if {[%%0]}{/var doSeq %%0} else {/var nSeq 0;/var doSeq 1;doSeq}}

/al tick+ {/if {$tickon_%%1}{showg #MYTICK %%1 was already ON.} else {/var tickon_%%1 1;/var ticksize_%%1 %%2;/al tick_%%1 {/if {$tickon_%%%%1}{%%%%1;/sleep $ticksize_%%%%1;tick_%%%%1}};showg #MYTICK %%1 turned on, size=%%2;tick_%%1}}
/al tick- {/var tickon_%1 0}
