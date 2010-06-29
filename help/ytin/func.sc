/nop ***********************************************************************
/nop since we do not have local variables for function, I suggest variables
/nop that means to be local to be ended with _
/nop ***********************************************************************

/nop some important alias
/al ini {/if {[%%2=]}{/var default_ 0} else {/var default_ %%2};/ife {%%1}{/nop} else {/var %%1 $default_}}

/nop function @replace only do once
/func replace {/var arg1 %1;/var arg2 %2;/var arg3 {};/var arg3 %3;/strstr ${$arg1} $arg2;/if {$_>=0}{/var i1_ $_;/substr ${$arg1} 0 $i1_;/if {[$_=]}{/var h_ {}} else {/var h_ {$_}};/strlen $arg2;/math i2_ $i1_+$_;/strlen ${$arg1};/math l_ $_-$i2_;/substr ${$arg1} $i2_ $l_;/var {$arg1} {$h_$arg3$_};/result 1} else {/result 0}}

/nop alias replace will do loop
/al replace {/if {@replace{{%%%%1} {%%%%2} {%%%%3}}}{replace {%%%1} {%%%2} {%%%3}}}

/al appendlist {/ife {%%1}{/nop} else {/var {%%%1} {}};/if {@strlen{%%%1}+@strlen{%%%2}>4000}{showg TOO LONG: %%1} else {/if {[${%%%%1}=]}{/nop} else {/var {%%%%1} ${%%%%1}$delim};/var {%%%1} ${%%%1}%%2}}
/al removelist {/var {%%1} {$delim${%%%1}$delim};replace {%%1} {${delim}%%2$delim} {$delim};/strlen $delim;/math l_ -$_;/substr ${%%1} $_ $l_;/if {[$_=]}{/var {%%%1} {}} else {/var {%%%1} {$_}}}

/nop check if two lists have any common element
/func matchlists {/var matchlists 0;/forall {%%1}{/forall {%%%2}{/if {[%%0=%%%0]}{/var matchlists 1}}};/result $matchlists}

/nop Here are some useful variables
/chr _nl 10
/var _lbra [;/nop useful for compare in /if {[ ]}
/var _rbra ]
/chr _lcbra 123;/nop left curry bracket
/chr _rcbra 125

/chr _SE	    240
/chr _NOP	    241
/chr _DM	    242
/chr _BREAK	    243
/chr _IP	    244
/chr _AO	    245
/chr _AYT	    246
/chr _EC	    247
/chr _EL	    248
/chr _GOAHEAD	249
/chr _SB	    250
/chr _TEL_WILL	251
/chr _TEL_WONT	252
/chr _TEL_DO	253
/chr _TEL_DONT	254
/chr _IAC	    255
/chr _TEL_IS     0
/chr _TEL_SEND   1
/chr _TEL_INFO   2
/chr _TERMTYPE   24

/al termtype {/raw $_IAC$_SB$_TERMTYPE;/raw0;/raw %0$_IAC$_SE}

/nop functions
/func strstr {/strstr {%%1} {%%2};/res $_}
/func strlen {/strlen {%%1};/res $_}
/func substr {/math v2_ %2;/math v3_ %3;/substr {%%1} $v2_ $v3_;/res $_}
/func chr {/chr _ {%%0};/res $_}
/func ord {/ord _ {%%0};/res $_}
/func isdigit {/if {@ord{%%%0}>=@ord{0} && @ord{%%%0}<=@ord{9}}{/res 1} else {/res 0}}
/func fopen {/fopen {%%1} {%%2};/res $_}
/func fgets {/fgets {%%1} {2048} {%%2};/res $_}
/al chomp {/var t_ {$%%1};/math l_ @strlen{$t_}-1;/if {$l_>=0}{/var v_ @ord{@substr{$t_ $l_ 1}};/if {$v_=13 || $v_=10}{/var %%%1 @substr{$t_ 0 $l_}}} }
/func getl {/getl {_} {%%0};/res $_}
/func randitem {/var l_ @getl{%%0};/math i_ $_random//$l_;/geti _ $i_ {%%0};/res $_}
/func stripansi {/stripansi _ {%%0};/res $_}
/func rcvAnsi {/var a_ {%%0};/var b_ {};/strlen $a_;/var l_ $_;/if {$l_<4} {/result $a_} else {/loop {0,$l_-1}{/var i_ %0;/substr $a_ $i_ 2;/if {[$_= $_lbra]}{/var b_ $b_$_ESC} else {/substr $_ 0 1;/var b_ $b_$_}};/result $b_}}
