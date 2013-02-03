var TINY={};
var PLAYER='http://fastpics.eu/mediaplayer.swf';
//var PLAYER='pl/player.swf';
var VIEWVIDEO="http://strip.totalh.com/tbox/viewvideo.jpg";
var THCLICK="http://strip.totalh.com/tbox/click.jpg";
var VIEWPLAY="http://strip.totalh.com/tbox/viewplay.jpg";
var H_Def=0;
var W_Def=0;

function T$(i){return document.getElementById(i)}
function TPIC$(i){return document.getElementById('TINY_popup'+i)}


TINY.box=function(){
    var dc,cl;    
    var dc2,dc3,cp,cn;
    var cnum;
    var ctit,dctit,ct;
    var p,m,b,fn,ic,iu,iw,ih,ia,f=0;    
	return{
		show:function(c,u,w,h,a,t,num,tit){
                  cnum=num;ctit=tit;
                  //alert(ctit);
                  if ((tit) && (num>1))
                  {
                    c='<span style="position: relative; height:10px; width: '+w+'px;">'+c
                    +'<cite style="background: #111; filter:alpha(opacity=75);opacity:.75;color: #fff;position: absolute;bottom: 5px;left: 0;padding: 5px;border-top: 1px solid #999;">'
                    +tit+'</cite></span>';
                  }
			if(!f){
				p=document.createElement('div'); 
                        p.style.position='absolute';
                        p.style.display='none';
                        p.style.padding='10px';
                        p.style.backgroundColor='#FFF';
                        p.style.border='10px';
                        p.style.zIndex=2000;

				m=document.createElement('div'); 
                        m.style.position='absolute';
                        m.style.display='none';
                        m.style.top=0;
                        m.style.left=0; 
                        m.style.height='100%'; 
                        m.style.width='100%'; 
                        m.style.backgroundColor='#000';
                        m.style.zIndex=1500;

				b=document.createElement('div'); b.style.backgroundColor='#FFF';
				dc=document.createElement('div');
                        dc.style.position='absolute';
                        dc.style.display='none';
                        dc.style.top=0;
                        dc.style.left=0; 
                        dc.style.height='100%'; 
                        dc.style.width='100%'; 
                        dc.style.backgroundColor='#FFF';
                        dc.style.zIndex=1501;

				dc2=document.createElement('div');
                        dc2.style.position='absolute';
                        dc2.style.display='none';
                        dc2.style.top=0;
                        dc2.style.left=0; 
                        dc2.style.height='100%'; 
                        dc2.style.width='100%'; 
                        dc2.style.backgroundColor='#FFF';
                        dc2.style.zIndex=1502;                     

                        cp=document.createElement('a');cp.appendChild(document.createTextNode('[<]'));cp.onclick=TINY.box.prev;cp.style.cursor='pointer';dc2.appendChild(cp);                        
                        document.body.appendChild(dc2);

				dc3=document.createElement('div');
                        dc3.style.position='absolute';
                        dc3.style.display='none';
                        dc3.style.top=0;
                        dc3.style.left=0; 
                        dc3.style.height='100%'; 
                        dc3.style.width='100%'; 
                        dc3.style.backgroundColor='#FFF';
                        dc3.style.zIndex=1502;

                        cn=document.createElement('a');cn.appendChild(document.createTextNode('[>]'));cn.onclick=TINY.box.next;cn.style.cursor='pointer';dc3.appendChild(cn);
                        document.body.appendChild(dc3);


				dctit=document.createElement('div');
                        dctit.style.position='absolute';
                        dctit.style.display='none';
                        dctit.style.top=0;
                        dctit.style.left=0; 
                        dctit.style.height='100%'; 
                        dctit.style.width='100%'; 
                        dctit.style.backgroundColor='#FFF';
                        dctit.style.zIndex=1503;                       
                        ct=document.createElement('a');ct.appendChild(document.createTextNode(ctit));dctit.appendChild(ct);
                        document.body.appendChild(dctit);


				cl=document.createElement('a');cl.appendChild(document.createTextNode('[X]'));cl.onclick=TINY.box.hide;cl.style.cursor='pointer';
				dc.appendChild(cl);document.body.appendChild(dc);
				document.body.appendChild(m); document.body.appendChild(p); 
				p.appendChild(b);				
				window.onresize=TINY.box.resize; f=1
									
			       }
			if(!a&&!u){
				p.style.width=w?w+'px':'auto'; p.style.height=h?h+'px':'auto';
				p.style.backgroundImage='none'; 
                        b.innerHTML=c;			                        
			}else{
				b.style.display='none'; p.style.width=p.style.height='100px'
				//alert("Ok");
			}
			dc.style.width='20px';dc.style.height='20px';
			dc.style.display='block';

                  if (TPIC$(cnum-1))
                  {                   
                   dc2.style.width='20px';dc2.style.height='20px';dc2.style.display='block';
                  } else
                  {
                   dc2.style.display='none';
                  }
                  if (TPIC$(cnum+1))
                  {
			 dc3.style.width='20px';dc3.style.height='20px';dc3.style.display='block';
                  } else
                  {
                   dc3.style.display='none';
                  }
                  
                  if ((ctit) && (!cnum))
                  {
                   dctit.style.width=w+'px';
                   dctit.style.height='20px';dctit.style.display='block';
                  }
                  
                  dctit.style.display='none';
                  dctit.innerHTML=tit;
                                    
			
			this.mask();
			ic=c; iu=u; iw=w; ih=h; ia=a; this.alpha(m,1,80,3);
			
			//dc.style=p.style;dc.style.display='block';
			if(t){setTimeout(function(){TINY.box.hide()},1000*t)}
			
			
		},
		fill:function(c,u,w,h,a){
			if(u){
				p.style.backgroundImage='';
				var x=window.XMLHttpRequest?new XMLHttpRequest():new ActiveXObject('Microsoft.XMLHTTP');
				x.onreadystatechange=function(){
					if(x.readyState==4&&x.status==200){TINY.box.psh(x.responseText,w,h,a)}
				};
				x.open('GET',c,1); x.send(null)
			}else{
				this.psh(c,w,h,a)
			}			
		},
		psh:function(c,w,h,a){
			if(a){
				if(!w||!h){
					var x=p.style.width, y=p.style.height; b.innerHTML=c;
					p.style.width=w?w+'px':''; p.style.height=h?h+'px':'';
					b.style.display='';
					w=parseInt(b.offsetWidth); h=parseInt(b.offsetHeight);
					b.style.display='none'; p.style.width=x; p.style.height=y;					
				}else{
					b.innerHTML=c
				}
				this.size(p,w,h)
			}else{
				p.style.backgroundImage='none'
			}			
		},
		hide:function(){
			TINY.box.alpha(p,-1,0,3);
			dc.style.display='none';
                  dc2.style.display='none';
                  dc3.style.display='none';
                  dctit.style.display='none';
		},
            prev:function(){
                  var num=cnum-1;
                  popupBlock(TPIC$(num),num);
		},
            next:function(){
                  var num=cnum+1;
                  popupBlock(TPIC$(num),num);
		},
		resize:function(){
			TINY.box.pos(); //TINY.box.mask()
		},
		mask:function(){
			m.style.height=TINY.page.total(1)+'px';
			m.style.width=''; m.style.width=TINY.page.total(0)+'px';	       
		},
		pos:function(){
			var t=(TINY.page.height()/2)-(p.offsetHeight/2); t=t<15?15:t;
			p.style.top=(t+TINY.page.top())+'px';
			p.style.left=(TINY.page.width()/2)-(p.offsetWidth/2)+'px';		
			dc.style.left=(parseInt(p.style.left)+p.offsetWidth-dc.offsetWidth)+'px';
			dc.style.top=(t+TINY.page.top())-18+'px';

                  dc2.style.left=(parseInt(p.style.left))+'px';
                  dc2.style.top=(t+TINY.page.top())-18+'px';
                  dc3.style.left=(parseInt(p.style.left))+dc2.offsetWidth+'px';
                  dc3.style.top=(t+TINY.page.top())-18+'px';
                  dctit.style.left=dc2.style.left;
                  dctit.style.top=dc2.style.top;

			this.mask();
		},
		alpha:function(e,d,a){
			clearInterval(e.ai);
			if(d==1){
				e.style.opacity=0; e.style.filter='alpha(opacity=0)';
				e.style.display='block'; this.pos()
			}
			e.ai=setInterval(function(){TINY.box.ta(e,a,d)},20)
		},
		ta:function(e,a,d){
			var o=Math.round(e.style.opacity*100);
			if(o==a){
				clearInterval(e.ai);
				if(d==-1){
					e.style.display='none';
					e==p?TINY.box.alpha(m,-1,0,2):b.innerHTML=p.style.backgroundImage=''
				}else{
					e==m?this.alpha(p,1,100):TINY.box.fill(ic,iu,iw,ih,ia)
				}
			}else{
				var n=Math.ceil((o+((a-o)*.5))); n=n==1?0:n;
				e.style.opacity=n/100; e.style.filter='alpha(opacity='+n+')'
			}
		},
		size:function(e,w,h){
			e=typeof e=='object'?e:T$(e); clearInterval(e.si);
			var ow=e.offsetWidth, oh=e.offsetHeight,
			wo=ow-parseInt(e.style.width), ho=oh-parseInt(e.style.height);
			var wd=ow-wo>w?0:1, hd=(oh-ho>h)?0:1;
			e.si=setInterval(function(){TINY.box.ts(e,w,wo,wd,h,ho,hd)},20);            
		},
		ts:function(e,w,wo,wd,h,ho,hd){
			var ow=e.offsetWidth-wo, oh=e.offsetHeight-ho;
			if(ow==w&&oh==h){
				clearInterval(e.si); p.style.backgroundImage='none'; b.style.display='block';
                        if ((ctit) && (!cnum))
                        {
                         dctit.style.display='block';
                        }
			}else{
				if(ow!=w){var n=ow+((w-ow)*.5); e.style.width=wd?Math.ceil(n)+'px':Math.floor(n)+'px'}
				if(oh!=h){var n=oh+((h-oh)*.5); e.style.height=hd?Math.ceil(n)+'px':Math.floor(n)+'px'}			
			}
                        this.pos();			
		}
	}
}();

TINY.page=function(){
	return{
		top:function(){return document.documentElement.scrollTop||document.body.scrollTop},
		width:function(){return self.innerWidth||document.documentElement.clientWidth||document.body.clientWidth},
		height:function(){return self.innerHeight||document.documentElement.clientHeight||document.body.clientHeight},
		total:function(d){
			var b=document.body, e=document.documentElement;
			return d?Math.max(Math.max(b.scrollHeight,e.scrollHeight),Math.max(b.clientHeight,e.clientHeight)):
			Math.max(Math.max(b.scrollWidth,e.scrollWidth),Math.max(b.clientWidth,e.clientWidth))
		}
	}
}();

function popupBlock(el,num) 
{
    var incCont =''; 
    var w=0;
    var h=0;
    var tit;

	// el.parentNode - ≥-≥øTèTÇTå TÄ≥-≥+≥øTÇ≥≥≥øTåTÅ≥≥≥ø≥≥ Tç≥ø≥≥≥-≥≥≥-TÇ
	// el.parentNode.childNodes - ≥-≥øTèTÇTå ≥-TÅ≥≥ ≥+≥-Tá≥≥TÄ≥-≥ø≥≥ Tç≥ø≥≥≥-≥≥≥-TÇTã TÄ≥-≥+≥øTÇ≥≥≥øTè
	// ≥ø ≥ø≥-≥ø≥-≥≥≥øTÇTå ≥øTÖ ≥- ≥-≥-TÅTÅ≥ø≥- kids
	var kids = el.parentNode.childNodes; 
	
	// ≥øTÄ≥-≥≥TÄTÉTÇ≥øTÇTå ≥- TÜ≥ø≥≥≥ø≥≥ ≥-TÅ≥≥ Tç≥ø≥≥≥-≥≥≥-TÇTã ≥-≥-TÅTÅ≥ø≥-≥- kids
	for (var k = 0; k < kids.length; k++) {
		var child = kids[k];
		// ≥≥TÅ≥ø≥ø ≥ø≥-Tè ≥≥≥ø≥-TÅTÅ≥- TÇ≥≥≥≥TÉTâ≥≥≥≥≥- Tç≥ø≥≥≥-≥≥≥-TÇ≥- TÄ≥-≥-≥-≥- TINY_block,
		// TÇ≥- ≥-Tã≥ø≥-≥ø≥-≥øTÇTå ≥-≥ø≥≥≥≥ TÅ≥ø≥≥≥+TÉTéTâ≥ø≥≥ ≥ø≥-TÅTÇTÄTÉ≥≥TÜ≥ø≥ø
		if (child && child.className == "TINY_block") {
			// ≥≥TÅ≥ø≥ø ≥-≥ø≥-≥≥ ≥-≥≥ ≥-≥ø≥+≥≥≥-, TÇ≥- ≥-Tã≥-≥≥TÅTÇ≥ø ≥≥≥≥≥- ≥- TÅ≥ø≥øTã≥-≥-TéTâ≥≥≥≥ ≥-≥≥≥-≥-
			if (child.style.display != 'block') 
			{
			  incCont=child.innerHTML;			  
			  //alert(child.innerText);
			  //alert(child.innerHTML);
			  w=parseInt(child.getAttribute('width'));
			  h=parseInt(child.getAttribute('height'));
                    tit=child.getAttribute('title');
                    //alert(child.innerHTML);
			  //alert(tit);
			} 			
		}
	}
	
	if ((incCont !='') && (w) && (h))
	{
	 TINY.box.show(incCont,0,w,h,1,0,num,tit);
	}
}

var TINY_pic_count=2;
var TINY_msg="";
function imgdo(p,url,fn,tit)
{    
    var el=document.getElementById(fn);
    var img=new Image();
    var fn='TINY_popup'+TINY_pic_count;
    var nm=TINY_pic_count;
    var msg=TINY_msg;
    img.onload=function ()
		{
                 w=img.width;h=img.height;
                 if (msg)
                 {
                    el.innerHTML='<span onclick="popupBlock(this,'+nm+'); " id="'+fn+'" style="cursor: pointer; position: relative; height:10px; width: 50px;">'
                    +'<img alt="View" src="'+p+'" /><cite style="background: #111; filter:alpha(opacity=75);opacity:.75;color: #fff;position: absolute;bottom: 5px;left: 0;padding: 5px;border-top: 1px solid #999;">'
                    +msg+'</cite></span>';
                 } else {                
                    el.innerHTML='<span onclick="popupBlock(this,'+nm+'); " id="'+fn+'" style="cursor: pointer;">'
                    +'<img alt="View" src="'+p+'" /></span>';
                 }
                 if (tit)
                 {
                  el.innerHTML+='<span class="TINY_block" style="display: none;" width="'+img.width+'" height="'+img.height+'" title="'+tit+'" ><img alt="View" src="'+url+'" />';
                 } else
                 {
                  el.innerHTML+='<span class="TINY_block" style="display: none;" width="'+img.width+'" height="'+img.height+'" ><img alt="View" src="'+url+'" />';
                 }
                 el.innerHTML+='</span>';
		}
	img.src=url;
}

function pic_out(p,v,msg)
{
var fn='TINY_pic'+TINY_pic_count;
document.write('<span id="'+fn+'">Load</span>');
imgdo(p,v,fn,msg);
TINY_pic_count=TINY_pic_count+1;
}
function pic_new(p)
{
TINY_pic_count=TINY_pic_count+1;
TINY_msg=p;
}
function tb_label(p)
{
TINY_msg=p;
}
function tb_size(w,h)
{
 W_Def=w;H_Def=h;
}
function Tinybox_outwh(p,el,w,h,tit)
{
var ph;
if (p=="") p=THCLICK;
if (TINY_msg)
{
 ph='<span onclick="popupBlock(this,0);" style="cursor: pointer; position: relative; height:10px; width: 50px;">'    
     +'<img alt="View" src="'+p+'" /><cite style="background: #111; filter:alpha(opacity=75);opacity:.75;color: #fff;position: absolute;bottom: 5px;left: 0;padding: 5px;border-top: 1px solid #999;">'
     +TINY_msg+'</cite></span>';
} else
{
 ph='<span onclick="popupBlock(this,0);" style="cursor: pointer;">'
    +'<img alt="View" src="'+p+'" /></span>';
}
if (tit)
{
 ph+='<span class="TINY_block" style="display: none;" width="'+w+'" height="'+h+'" title="'+tit+'">'+el+'</span>';
} else
{
 ph+='<span class="TINY_block" style="display: none;" width="'+w+'" height="'+h+'">'+el+'</span>';
}
document.write('<span>'+ph+'</span>');
}

function pic_outwh(p,v,w,h,tit)
{
 Tinybox_outwh(p,'<img alt="View" src="'+v+'" />',w,h,tit);
}


function video_outwh(p,v,w,h,tit)
{
var el;
if (p=="") p=VIEWVIDEO;
el='<embed src="'+PLAYER+'" allowscriptaccess="always" allowfullscreen="true" flashvars="width='
+w+'&amp;height='+h+'&amp;file='+v+'&amp;image='+p+'&amp;searchbar=false&amp;type=flv&amp;autostart=true" height="'+h+'" width="'+w+'" wmode="opaque">'
+'</embed>';
Tinybox_outwh(p,el,w,h,tit);
}

function video_out(p,v,tit)
{
 video_outwh(p,v,640,480,tit);
}

function flash_outwh(p,f,w,h,tit)
{
var el;
if (p=="") p=VIEWPLAY;
el='<embed src="'+f+'" width="'+w+'" height="'+h+'" quality="high" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" menu="false"></embed>';
Tinybox_outwh(p,el,w,h,tit);
}

function flash_out(f,v,tit)
{
 flash_outwh(f,v,640,480,tit);
}

function youtubewh(c,w,h,tit)
{
var el;
var p='http://0.gvt0.com/vi/'+c+'/hqdefault.jpg';
el='<object width="'+w+'" height="'+h+'"><param name="movie" value="http://www.youtube.com/v/'+c+'?fs=1&amp;rel=0&amp;autoplay=1"></param>'
  +'<param name="allowFullScreen" value="true"></param><param name="allowscriptaccess" value="always"></param>'
  +'<embed src="http://www.youtube.com/v/'+c+'?fs=1&amp;rel=0&amp;autoplay=1" type="application/x-shockwave-flash" allowscriptaccess="always" allowfullscreen="true"' 
  +'width="'+w+'" height="'+h+'"></embed></object>';
Tinybox_outwh(p,el,w,h,tit);
}

function youtube(c,tit)
{
 youtubewh(c,480,385,tit);
}

function smotri(p,c,tit)
{
  var el,w,h;
  if (p=="") p=VIEWVIDEO;
  h=H_Def;w=W_Def;
  if (w==0) w=640;
  if (h==0) h=480;
  var f='http://pics.smotri.com/player.swf?file='+c+'&bufferTime=3&autoStart=false&str_lang=rus&xmlsource=http%3A%2F%2Fpics.smotri.com%2Fcskins%2Fblue%2Fskin_color.xml&xmldatasource=http%3A%2F%2Fpics.smotri.com%2Fskin_ng.xml'
  el='<embed src="'+f+'" width="'+w+'" height="'+h+'" quality="high" allowfullscreen="true" pluginspage="http://www.macromedia.com/go/getflashplayer"'
    +' type="application/x-shockwave-flash" menu="false"></embed>';
  Tinybox_outwh(p,el,w,h,tit);
}

function pornhub(p,i,tit)
{
var el,w,h;
if (p=="") p=VIEWVIDEO;
h=H_Def;w=W_Def;
if (w==0) w=608;
if (h==0) h=476;
el='<object id="PHUBMXPlayer" classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000" width="'+w+'" height="'+h+'">'
+'<param name="name" value="PHUBMXPlayer" /><param name="bgcolor" value="#000000" />'
+'<param name="flashvars" value="vkey='+i+'&amp;quality=-1&amp;options=http://www.pornhub.com/" /><param name="src" value="http://www.pornhub.com/cdn_files/flash/player_v1.swf" />'
+'<param name="wmode" value="transparent" /><param name="allowfullscreen" value="true" />'
+'<param name="quality" value="high" /><embed id="PHUBMXPlayer" type="application/x-shockwave-flash" width="'+w+'" height="'+h
+'" src="http://www.pornhub.com/cdn_files/flash/player_v1.swf" quality="high" allowfullscreen="true" wmode="transparent" flashvars="vkey='+i
+'&amp;quality=-1&amp;options=http://www.pornhub.com/" bgcolor="#000000" name="PHUBMXPlayer"></embed></object>';
Tinybox_outwh(p,el,w,h,tit);
}

function mplayer(p,v,w,h,tit)
{
var el;
if (p=="") p=VIEWVIDEO;
el='<object classid="clsid:6BF52A52-394A-11D3-B153-00C04F79FAA6" codebase="http://activex.microsoft.com/activex/controls/mplayer/en/nsmp2inf.cab#Version=5,1,52,701" height="'+h+'" width="'+w+'">'
+'<param name="width" value="'+w+'"/><param name="height" value="'+h+'"/>'
+'<param name="src" value="'+v+'"/>'
+'<param name="url" value="'+v+'"/>'
+'<embed type="application/x-mplayer2" src="'+v+'" height="'+h+'" width="'+w+'"/>'
+'</object>';
Tinybox_outwh(p,el,w,h,tit);
}

function dailymotion(p,i,tit)
{
var el,h,w;
if (p=="") p=VIEWVIDEO;
h=H_Def;w=W_Def;
if (w==0) w=480;
if (h==0) h=360;
el='<iframe frameborder="0" width="'+w+'" height="'+h+'" src="http://www.dailymotion.com/embed/video/'+i+'"></iframe>';
Tinybox_outwh(p,el,w,h,tit);
}

function keezmovies(p,i,tit)
{
var el,w,h;
if (p=="") p=VIEWVIDEO;
h=H_Def;w=W_Def;
if (w==0) w=608;
if (h==0) h=476;
el='<object type="application/x-shockwave-flash" data="http://km-static.phncdn.com/flash/player_embed.swf?cache=005" width="'+w+'" height="'+h+'">'
+'<param name="bgColor" value="#000000"/>'
+'<param name="allowfullscreen" value="true"/>'
+'<param name="allowScriptAccess" value="always"/>'
+'<param name="FlashVars" value="options=http://www.keezmovies.com/embed_player.php?id='+i+'"/>'
+'<param name="movie" value="http://km-static.phncdn.com/flash/player_embed.swf?cache=005"/>'
+'</object>';
Tinybox_outwh(p,el,w,h,tit);
}
function slutload(p,i,tit)
{
var el,h,w;
if (p=="") p=VIEWVIDEO;
h=H_Def;w=W_Def;
if (w==0) w=450;
if (h==0) h=330;
el='<object type="application/x-shockwave-flash" data="http://emb.slutload.com/'+i+'" width="'+w+'" height="'+h+'"><param name="AllowScriptAccess" value="always">'
+'<param name="movie" value="http://emb.slutload.com/'+i+'"></param><param name="allowfullscreen" value="true"></param>'
+'<embed src="http://emb.slutload.com/'+i+'" AllowScriptAccess="always" allowfullscreen="true" width="'+w+'" height="'+h+'"></embed></object>';
Tinybox_outwh(p,el,w,h,tit);
}
function megaporn(p,i,tit)
{
var el,h,w;
if (p=="") p=VIEWVIDEO;
h=H_Def;w=W_Def;
if (w==0) w=640;
if (h==0) h=467;
el='<object width="'+w+'" height="'+h+'"><param name="movie" value="http://www.megaporn.com/e/'+i+'"></param>'
+'<param name="allowFullScreen" value="true"></param><embed src="http://www.megaporn.com/e/'+i+'" type="application/x-shockwave-flash" allowfullscreen="true" width="'+w+'" height="'+h+'">'
+'</embed></object>';
Tinybox_outwh(p,el,w,h,tit);
}
function xvideos(p,i,tit)
{
var el,h,w;
if (p=="") p=VIEWVIDEO;
h=H_Def;w=W_Def;
if (w==0) w=510;
if (h==0) h=400;
el='<iframe src="http://flashservice.xvideos.com/embedframe/'+i+'" frameborder=0 width='+w+' height='+h+' scrolling=no></iframe>';
Tinybox_outwh(p,el,w,h,tit);
}
function xhamster(p,i,tit)
{
var el,h,w;
if (p=="") p=VIEWVIDEO;
h=H_Def;w=W_Def;
if (w==0) w=510;
if (h==0) h=400;
el='<iframe width="'+w+'" height="'+h+'" src="http://xhamster.com/xembed.php?video='+i+'" frameborder="0" scrolling="no"></iframe>';
Tinybox_outwh(p,el,w,h,tit);
}
function redtube(p,i,tit)
{
var el,h,w;
if (p=="") p=VIEWVIDEO;
h=H_Def;w=W_Def;
if (w==0) w=434;
if (h==0) h=344;
el='<object width="'+w+'" height="'+h+'" classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000" codebase="http://fpdownload.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=8,0,0,0" >'
+'<param name="allowScriptAccess" value="always" /><param name="movie" value="http://embed.redtube.com/player/" />'
+'<param name="allowFullScreen" value="true" /><param name="flashvars" value="id='+i+'&style=redtube" />'
+'<embed src="http://embed.redtube.com/player/?id='+i+'&style=redtube" allowfullscreen="true" flashvars="autostart=true" width="'+w+'" height="'+h+'" '
+'type="application/x-shockwave-flash" pluginspage="http://www.adobe.com/shockwave/download/download.cgi?P1_Prod_Version=ShockwaveFlash" />'
+'</object>';
Tinybox_outwh(p,el,w,h,tit);
}
