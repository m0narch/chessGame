let SessionLoad = 1
if &cp | set nocp | endif
let s:cpo_save=&cpo
set cpo&vim
inoremap <silent> <S-Tab> =BackwardsSnippet()
vmap  y:call system("xclip -i selection clipboard",getreg("\"")):call system("xclip -i",getreg("\""))
vmap  :call OpenWebBrowser("http://www.google.fr/")
map  :call ToggleHex()
snoremap <silent> 	 i<Right>=TriggerSnippet()
map <NL> :tabprevious
map  :tabnext
map <silent>  :set invhlsearch
vmap  :call OpenWebBrowser("")
map  :call JCommentWriter()
vmap  :call OpenWebBrowser("http://fr.wikipedia.org/wiki/")
nmap  :NERDTreeToggle
xmap  :NERDTreeToggle
snoremap  b<BS>
omap  :NERDTreeToggle
map  :tab split:exec("tag ".expand("<cword>"))
nnoremap <silent> r :TCommentRight
nnoremap <silent>  :TComment
noremap s :TCommentAs =&ft_
noremap n :TCommentAs =&ft 
noremap a :TCommentAs 
noremap b :TCommentBlock
vnoremap <silent> r :TCommentRight
vnoremap <silent> i :TCommentInline
onoremap <silent> r :TCommentRight
noremap   :TComment 
noremap <silent> p m`vip:TComment``
vnoremap <silent>  :TCommentMaybeInline
onoremap <silent>  :TComment
nnoremap   za
map ! :w
snoremap % b<BS>%
snoremap ' b<BS>'
nnoremap <silent> ,_r :TCommentRight
snoremap <silent> ,_r :TCommentRight
nnoremap <silent> ,__ :TComment
snoremap <silent> ,__ :TComment
nmap <silent> ,b :CommandTBuffer
nmap <silent> ,t :CommandT
noremap ,_s :TCommentAs =&ft_
noremap ,_n :TCommentAs =&ft 
noremap ,_a :TCommentAs 
noremap ,_b :TCommentBlock
xnoremap <silent> ,_r :TCommentRight
onoremap <silent> ,_r :TCommentRight
xnoremap <silent> ,_i :TCommentInline
noremap ,_  :TComment 
noremap <silent> ,_p vip:TComment
xnoremap <silent> ,__ :TCommentMaybeInline
onoremap <silent> ,__ :TComment
nmap ,a <Plug>ToggleAutoCloseMappings
nmap ,ihn :IHN
nmap ,is :IHS:A
nmap ,ih :IHS
map ,c :call CommentToggleSmart("3", '/*', '*/')
map ,f :call OpenCFiles()
map ,e :tabe 
noremap / :call SearchCompleteStart()/
map ; A;
vmap < <gv
vmap > >gv
imap ð :call SearchInvalidComment(1)a
imap î :call SearchInvalidComment(0)a
imap ã :call JCommentWriter()
nnoremap Q @q
snoremap U b<BS>U
nnoremap Y y$
snoremap \ b<BS>\
snoremap ^ b<BS>^
snoremap ` b<BS>`
nmap gx <Plug>NetrwBrowseX
xnoremap <silent> gC :TCommentMaybeInline
nnoremap <silent> gCc :let w:tcommentPos = getpos(".") | set opfunc=tcomment#OperatorLineAnywayg@$
nnoremap <silent> gC :let w:tcommentPos = getpos(".") | set opfunc=tcomment#OperatorAnywayg@
xnoremap <silent> gc :TCommentMaybeInline
nnoremap <silent> gcc :let w:tcommentPos = getpos(".") | set opfunc=tcomment#OperatorLineg@$
nnoremap <silent> gc :let w:tcommentPos = getpos(".") | set opfunc=tcomment#Operatorg@
nmap <Right> <Nop>
xmap <Right> <Nop>
nmap <Left> <Nop>
xmap <Left> <Nop>
omap <Right> <Nop>
omap <Left> <Nop>
map <Down> <Nop>
map <Up> <Nop>
snoremap <Left> bi
snoremap <Right> a
snoremap <BS> b<BS>
snoremap <silent> <S-Tab> i<Right>=BackwardsSnippet()
nnoremap <silent> <Plug>NetrwBrowseX :call netrw#NetrwBrowseX(expand("<cWORD>"),0)
map <silent> <F5> gg=G
map <F3> :mksession!
map <F4> :Lodgeit
map <F2> :set spell!
map <F8> :Tlist
map <silent> <C-F12> :wa:silent make clean:cw:cw:redraw!<F12>:!ctags -R .
map <silent> <F12> :wa:silent make:cw:cw:redraw!
inoremap <silent> 	 =TriggerSnippet()
imap  =Smart_TabComplete()
inoremap <silent> 	 =ShowAvailableSnips()
inoremap  u
inoremap s :TCommentAs =&ft_
inoremap n :TCommentAs =&ft 
inoremap a :TCommentAs 
inoremap b :TCommentBlock
inoremap <silent> r :TCommentRight
inoremap   :TComment 
inoremap <silent> p :norm! m`vip:TComment``
inoremap <silent>  :TComment
imap ,ihn :IHN
imap ,is :IHS:A
imap ,ih :IHS
map ð :call SearchInvalidComment(1)
map î :call SearchInvalidComment(0)
map ã :call JCommentWriter()
iabbr }- }h%?\w:nohl:call JCommentWriter()
let &cpo=s:cpo_save
unlet s:cpo_save
set autoindent
set background=dark
set backspace=indent,eol,start
set backup
set backupdir=~/.vim/backup/
set completefunc=VjdeCompletionFun0
set completeopt=longest,menuone,preview
set fileencodings=ucs-bom,utf-8,default,latin1
set helplang=fr
set hlsearch
set ignorecase
set incsearch
set laststatus=2
set mouse=a
set omnifunc=syntaxcomplete#Complete
set path=.,**
set ruler
set runtimepath=~/.vim,~/.vim/bundle/command-t,~/.vim/bundle/javabrowser,~/.vim/bundle/nerdtree,~/.vim/bundle/powerline,~/.vim/bundle/snipMate,~/.vim/bundle/vjde,/usr/share/vim/vimfiles,/usr/share/vim/vim73,/usr/share/vim/vimfiles/after,~/.vim/bundle/snipMate/after,~/.vim/after,~/.vim/eclim,~/.vim/eclim/after
set scrolloff=10
set shiftwidth=4
set showcmd
set smartcase
set smartindent
set smarttab
set spelllang=fr,en
set statusline=%F%m%r%h%w\ [TYPE=%Y\ %{&ff}]\ [%l/%L\ (%p%%)]
set suffixes=.bak,~,.swp,.o,.info,.aux,.log,.dvi,.bbl,.blg,.brf,.cb,.ind,.idx,.ilg,.inx,.out,.toc,.class
set switchbuf=usetab,newtab
set tabstop=4
set tags=./tags;/
set wildignore=*.o,*.class,*.pyc,*.obj,*.svnignore
let s:so_save = &so | let s:siso_save = &siso | set so=0 siso=0
let v:this_session=expand("<sfile>:p")
silent only
cd ~/Cours/p_java
if expand('%') == '' && !&modified && line('$') <= 1 && getline(1) == ''
  let s:wipebuf = bufnr('%')
endif
set shortmess=aoO
badd +1 src/fr/miblack/chess/color/Color.java
badd +1 src/fr/miblack/chess/piece/Bishop.java
badd +1 src/fr/miblack/chess/piece/King.java
badd +1 src/fr/miblack/chess/piece/Knight.java
badd +1 src/fr/miblack/chess/piece/Pawn.java
badd +1 src/fr/miblack/chess/piece/Piece.java
badd +1 src/fr/miblack/chess/piece/Queen.java
badd +1 src/fr/miblack/chess/piece/Rook.java
badd +1 src/fr/miblack/chess/Chessboard.java
badd +1 src/fr/miblack/chess/Game.java
badd +1 src/fr/miblack/chess/Main.java
badd +1 src/fr/miblack/chess/Move.java
badd +1 src/fr/miblack/chess/Play.java
badd +1 src/fr/miblack/chess/Player.java
badd +1 src/fr/miblack/chess/Position.java
badd +1 src/fr/miblack/chess/PositionFactory.java
silent! argdel *
edit src/fr/miblack/chess/Position.java
set splitbelow splitright
set nosplitbelow
set nosplitright
wincmd t
set winheight=1 winwidth=1
argglobal
nnoremap <buffer> <silent> ,jd :call VjdeGetDocUnderCursor()
nnoremap <buffer> <silent> ,as :call VjdeAppendTemplate("Singleton")
nnoremap <buffer> <silent> ,ii :call VjdeImplementInner()
nnoremap <buffer> <silent> ,oi :call Vjde_override(1)
nnoremap <buffer> <silent> ,oe :call Vjde_override(0)
vnoremap <buffer> <silent> ,en :call Vjde_rft_const()
nnoremap <buffer> <silent> ,ep :call Vjde_rft_arg()
nnoremap <buffer> <silent> ,em :call Vjde_rft_var(1)
nnoremap <buffer> <silent> ,el :call Vjde_rft_var(2)
nnoremap <buffer> <silent> ,ri :call Vjde_remove_imports()
nnoremap <buffer> <silent> ,ai :call Vjde_fix_import1()
nnoremap <buffer> <silent> ,fi :call Vjde_fix_import()
nnoremap <buffer> <silent> ,ft :call Vjde_fix_try()
nnoremap <buffer> <silent> ,fr :call Vjde_fix_throws()
vnoremap <buffer> <silent> ,js :call Vjde_sort_import()
vnoremap <buffer> <silent> ,jt :call Vjde_surround_try()
nnoremap <buffer> <silent> ,jt :call Vjde_surround_try()
nnoremap <buffer> <silent> ,jc :call VjdeGenerateConstructor()
nnoremap <buffer> <silent> ,jg :call Vjde_get_set()
nnoremap <buffer> <silent> ,je :call Vjde_ext_import()
inoreabbr <buffer> logger logger=eclim#java#logging#LoggingInit("logger")
inoreabbr <buffer> log log=eclim#java#logging#LoggingInit("log")
setlocal keymap=
setlocal noarabic
setlocal autoindent
setlocal nobinary
setlocal bufhidden=
setlocal buflisted
setlocal buftype=
setlocal cindent
setlocal cinkeys=0{,0},0),:,0#,!^F,o,O,e
setlocal cinoptions=j1
setlocal cinwords=if,else,while,do,for,switch
setlocal colorcolumn=
setlocal comments=sO:*\ -,mO:*\ \ ,exO:*/,s1:/*,mb:*,ex:*/,://,b:#,:%,:XCOMM,n:>,fb:-
setlocal commentstring=//%s
setlocal complete=.,w,b,u,t,i
setlocal concealcursor=
setlocal conceallevel=0
setlocal completefunc=VjdeCompletionFun0
setlocal nocopyindent
setlocal cryptmethod=
setlocal nocursorbind
setlocal nocursorcolumn
setlocal nocursorline
setlocal define=
setlocal dictionary=
setlocal nodiff
setlocal equalprg=
setlocal errorformat=%E%f:%l:\ %m,%-Z%p^,%-C%.%#,%-G%.%#
setlocal noexpandtab
if &filetype != 'java'
setlocal filetype=java
endif
setlocal foldcolumn=0
setlocal foldenable
setlocal foldexpr=0
setlocal foldignore=#
setlocal foldlevel=0
setlocal foldmarker={{{,}}}
setlocal foldmethod=manual
setlocal foldminlines=1
setlocal foldnestmax=20
setlocal foldtext=foldtext()
setlocal formatexpr=
setlocal formatoptions=croql
setlocal formatlistpat=^\\s*\\d\\+[\\]:.)}\\t\ ]\\s*
setlocal grepprg=
setlocal iminsert=0
setlocal imsearch=0
setlocal include=^s*import
setlocal includeexpr=substitute(v:fname,'\\.','/','g')
setlocal indentexpr=GetJavaIndent()
setlocal indentkeys=0{,0},:,0#,!^F,o,O,e,0=extends,0=implements
setlocal noinfercase
setlocal iskeyword=@,48-57,_,192-255
setlocal keywordprg=
setlocal nolinebreak
setlocal nolisp
setlocal nolist
setlocal makeprg=javac
setlocal matchpairs=(:),{:},[:]
setlocal modeline
setlocal modifiable
setlocal nrformats=octal,hex
set number
setlocal number
setlocal numberwidth=4
setlocal omnifunc=javacomplete#Complete
setlocal path=
setlocal nopreserveindent
setlocal nopreviewwindow
setlocal quoteescape=\\
setlocal noreadonly
setlocal norelativenumber
setlocal norightleft
setlocal rightleftcmd=search
setlocal noscrollbind
setlocal shiftwidth=4
setlocal noshortname
setlocal smartindent
setlocal softtabstop=0
setlocal nospell
setlocal spellcapcheck=[.?!]\\_[\\])'\"\	\ ]\\+
setlocal spellfile=
setlocal spelllang=fr,en
setlocal statusline=%!Pl#Statusline({'r':\ '%(%(%#Ple7ffffffa0d70000b#\ %{Powerline#Functions#GetMode()}\ %)%#Pla0d70000f0585858b#%)%(\ %(%#Plc4ff0000f0585858b#%{&readonly\ ?\ \"RO\"\ :\ \"\"}\ %)%(%#Ple7fffffff0585858b#%t\ %)%(%#Plc4ff0000f0585858b#%M\ %)%(%#Plc4ff0000f0585858b#%H%W\ %)%#Plf0585858ec303030b#%)%<%#Pl00ff0000ec303030N#%=%(%#Plec303030ec303030N#%(%#Plf79e9e9eec303030N#\ %{&fileformat}\ %)%)%(%#Plf79e9e9eec303030N#│%(%#Plf79e9e9eec303030N#\ %{(&fenc\ ==\ \"\"\ ?\ &enc\ :\ &fenc)}\ %)%)%(%#Plf79e9e9eec303030N#│%(%#Plf79e9e9eec303030N#\ %{strlen(&ft)\ ?\ &ft\ :\ \"no\ ft\"}\ %)%)%(%#Plf0585858ec303030N#%(%#Plfabcbcbcf0585858N#\ %3p%%\ %)%)%(%#Plfcd0d0d0f0585858b#%(%#Plec303030fcd0d0d0b#\ LN\ %3l%)%(%#Plf4808080fcd0d0d0N#\ C\ %-2c%)\ %)',\ 'n':\ '%(%(%#Pl16005f0094afd700b#\ %{Powerline#Functions#GetMode()}\ %)%#Pl94afd700f0585858b#%)%(\ %(%#Plc4ff0000f0585858b#%{&readonly\ ?\ \"RO\"\ :\ \"\"}\ %)%(%#Ple7fffffff0585858b#%t\ %)%(%#Plc4ff0000f0585858b#%M\ %)%(%#Plc4ff0000f0585858b#%H%W\ %)%#Plf0585858ec303030b#%)%<%#Pl00ff0000ec303030N#%=%(%#Plec303030ec303030N#%(%#Plf79e9e9eec303030N#\ %{&fileformat}\ %)%)%(%#Plf79e9e9eec303030N#│%(%#Plf79e9e9eec303030N#\ %{(&fenc\ ==\ \"\"\ ?\ &enc\ :\ &fenc)}\ %)%)%(%#Plf79e9e9eec303030N#│%(%#Plf79e9e9eec303030N#\ %{strlen(&ft)\ ?\ &ft\ :\ \"no\ ft\"}\ %)%)%(%#Plf0585858ec303030N#%(%#Plfabcbcbcf0585858N#\ %3p%%\ %)%)%(%#Plfcd0d0d0f0585858b#%(%#Plec303030fcd0d0d0b#\ LN\ %3l%)%(%#Plf4808080fcd0d0d0N#\ C\ %-2c%)\ %)',\ 'v':\ '%(%(%#Pl58870000d0ff8700b#\ %{Powerline#Functions#GetMode()}\ %)%#Pld0ff8700f0585858b#%)%(\ %(%#Plc4ff0000f0585858b#%{&readonly\ ?\ \"RO\"\ :\ \"\"}\ %)%(%#Ple7fffffff0585858b#%t\ %)%(%#Plc4ff0000f0585858b#%M\ %)%(%#Plc4ff0000f0585858b#%H%W\ %)%#Plf0585858ec303030b#%)%<%#Pl00ff0000ec303030N#%=%(%#Plec303030ec303030N#%(%#Plf79e9e9eec303030N#\ %{&fileformat}\ %)%)%(%#Plf79e9e9eec303030N#│%(%#Plf79e9e9eec303030N#\ %{(&fenc\ ==\ \"\"\ ?\ &enc\ :\ &fenc)}\ %)%)%(%#Plf79e9e9eec303030N#│%(%#Plf79e9e9eec303030N#\ %{strlen(&ft)\ ?\ &ft\ :\ \"no\ ft\"}\ %)%)%(%#Plf0585858ec303030N#%(%#Plfabcbcbcf0585858N#\ %3p%%\ %)%)%(%#Plfcd0d0d0f0585858b#%(%#Plec303030fcd0d0d0b#\ LN\ %3l%)%(%#Plf4808080fcd0d0d0N#\ C\ %-2c%)\ %)',\ 'i':\ '%(%(%#Pl17005f5fe7ffffffb#\ %{Powerline#Functions#GetMode()}\ %)%#Ple7ffffff1f0087afb#%)%(\ %(%#Plc4ff00001f0087afb#%{&readonly\ ?\ \"RO\"\ :\ \"\"}\ %)%(%#Ple7ffffff1f0087afb#%t\ %)%(%#Plc4ff00001f0087afb#%M\ %)%(%#Plc4ff00001f0087afb#%H%W\ %)%#Pl1f0087af18005f87b#%)%<%#Pl00ff000018005f87N#%=%(%#Pl18005f8718005f87N#%(%#Pl7587d7ff18005f87N#\ %{&fileformat}\ %)%)%(%#Pl7587d7ff18005f87N#│%(%#Pl7587d7ff18005f87N#\ %{(&fenc\ ==\ \"\"\ ?\ &enc\ :\ &fenc)}\ %)%)%(%#Pl7587d7ff18005f87N#│%(%#Pl7587d7ff18005f87N#\ %{strlen(&ft)\ ?\ &ft\ :\ \"no\ ft\"}\ %)%)%(%#Pl1f0087af18005f87N#%(%#Pl7587d7ff1f0087afN#\ %3p%%\ %)%)%(%#Pl7587d7ff1f0087afb#%(%#Pl17005f5f7587d7ffb#\ LN\ %3l%)%(%#Pl17005f5f7587d7ffN#\ C\ %-2c%)\ %)',\ 'N':\ '%(\ %(%#Pl58870000eb262626N#%{&readonly\ ?\ \"RO\"\ :\ \"\"}\ %)%(%#Plf58a8a8aeb262626b#%t\ %)%(%#Pl58870000eb262626N#%M\ %)%(%#Pl58870000eb262626N#%H%W\ %)%#Pleb262626e9121212b#%)%<%#Pl00ff0000e9121212N#%=%(%#Pleb262626e9121212N#%(%#Plef4e4e4eeb262626N#\ %3p%%\ %)%)%(%#Plf58a8a8aeb262626b#│%(%#Plf58a8a8aeb262626b#\ LN\ %3l%)%(%#Plf1626262eb262626N#\ C\ %-2c%)\ %)'},0)
setlocal suffixesadd=.java
setlocal swapfile
setlocal synmaxcol=3000
if &syntax != 'java'
setlocal syntax=java
endif
setlocal tabstop=4
setlocal tags=
setlocal textwidth=0
setlocal thesaurus=
setlocal noundofile
setlocal nowinfixheight
setlocal nowinfixwidth
setlocal wrap
setlocal wrapmargin=0
silent! normal! zE
let s:l = 22 - ((10 * winheight(0) + 30) / 61)
if s:l < 1 | let s:l = 1 | endif
exe s:l
normal! zt
22
normal! 0
tabedit src/fr/miblack/chess/Player.java
set splitbelow splitright
set nosplitbelow
set nosplitright
wincmd t
set winheight=1 winwidth=1
argglobal
nnoremap <buffer> <silent> ,jd :call VjdeGetDocUnderCursor()
nnoremap <buffer> <silent> ,as :call VjdeAppendTemplate("Singleton")
nnoremap <buffer> <silent> ,ii :call VjdeImplementInner()
nnoremap <buffer> <silent> ,oi :call Vjde_override(1)
nnoremap <buffer> <silent> ,oe :call Vjde_override(0)
vnoremap <buffer> <silent> ,en :call Vjde_rft_const()
nnoremap <buffer> <silent> ,ep :call Vjde_rft_arg()
nnoremap <buffer> <silent> ,em :call Vjde_rft_var(1)
nnoremap <buffer> <silent> ,el :call Vjde_rft_var(2)
nnoremap <buffer> <silent> ,ri :call Vjde_remove_imports()
nnoremap <buffer> <silent> ,ai :call Vjde_fix_import1()
nnoremap <buffer> <silent> ,fi :call Vjde_fix_import()
nnoremap <buffer> <silent> ,ft :call Vjde_fix_try()
nnoremap <buffer> <silent> ,fr :call Vjde_fix_throws()
vnoremap <buffer> <silent> ,js :call Vjde_sort_import()
vnoremap <buffer> <silent> ,jt :call Vjde_surround_try()
nnoremap <buffer> <silent> ,jt :call Vjde_surround_try()
nnoremap <buffer> <silent> ,jc :call VjdeGenerateConstructor()
nnoremap <buffer> <silent> ,jg :call Vjde_get_set()
nnoremap <buffer> <silent> ,je :call Vjde_ext_import()
inoreabbr <buffer> logger logger=eclim#java#logging#LoggingInit("logger")
inoreabbr <buffer> log log=eclim#java#logging#LoggingInit("log")
setlocal keymap=
setlocal noarabic
setlocal autoindent
setlocal nobinary
setlocal bufhidden=
setlocal buflisted
setlocal buftype=
setlocal cindent
setlocal cinkeys=0{,0},0),:,0#,!^F,o,O,e
setlocal cinoptions=j1
setlocal cinwords=if,else,while,do,for,switch
setlocal colorcolumn=
setlocal comments=sO:*\ -,mO:*\ \ ,exO:*/,s1:/*,mb:*,ex:*/,://,b:#,:%,:XCOMM,n:>,fb:-
setlocal commentstring=//%s
setlocal complete=.,w,b,u,t,i
setlocal concealcursor=
setlocal conceallevel=0
setlocal completefunc=VjdeCompletionFun0
setlocal nocopyindent
setlocal cryptmethod=
setlocal nocursorbind
setlocal nocursorcolumn
setlocal nocursorline
setlocal define=
setlocal dictionary=
setlocal nodiff
setlocal equalprg=
setlocal errorformat=%E%f:%l:\ %m,%-Z%p^,%-C%.%#,%-G%.%#
setlocal noexpandtab
if &filetype != 'java'
setlocal filetype=java
endif
setlocal foldcolumn=0
setlocal foldenable
setlocal foldexpr=0
setlocal foldignore=#
setlocal foldlevel=0
setlocal foldmarker={{{,}}}
setlocal foldmethod=manual
setlocal foldminlines=1
setlocal foldnestmax=20
setlocal foldtext=foldtext()
setlocal formatexpr=
setlocal formatoptions=croql
setlocal formatlistpat=^\\s*\\d\\+[\\]:.)}\\t\ ]\\s*
setlocal grepprg=
setlocal iminsert=0
setlocal imsearch=0
setlocal include=^s*import
setlocal includeexpr=substitute(v:fname,'\\.','/','g')
setlocal indentexpr=GetJavaIndent()
setlocal indentkeys=0{,0},:,0#,!^F,o,O,e,0=extends,0=implements
setlocal noinfercase
setlocal iskeyword=@,48-57,_,192-255
setlocal keywordprg=
setlocal nolinebreak
setlocal nolisp
setlocal nolist
setlocal makeprg=javac
setlocal matchpairs=(:),{:},[:]
setlocal modeline
setlocal modifiable
setlocal nrformats=octal,hex
set number
setlocal number
setlocal numberwidth=4
setlocal omnifunc=javacomplete#Complete
setlocal path=
setlocal nopreserveindent
setlocal nopreviewwindow
setlocal quoteescape=\\
setlocal noreadonly
setlocal norelativenumber
setlocal norightleft
setlocal rightleftcmd=search
setlocal noscrollbind
setlocal shiftwidth=4
setlocal noshortname
setlocal smartindent
setlocal softtabstop=0
setlocal nospell
setlocal spellcapcheck=[.?!]\\_[\\])'\"\	\ ]\\+
setlocal spellfile=
setlocal spelllang=fr,en
setlocal statusline=%!Pl#Statusline({'r':\ '%(%(%#Ple7ffffffa0d70000b#\ %{Powerline#Functions#GetMode()}\ %)%#Pla0d70000f0585858b#%)%(\ %(%#Plc4ff0000f0585858b#%{&readonly\ ?\ \"RO\"\ :\ \"\"}\ %)%(%#Ple7fffffff0585858b#%t\ %)%(%#Plc4ff0000f0585858b#%M\ %)%(%#Plc4ff0000f0585858b#%H%W\ %)%#Plf0585858ec303030b#%)%<%#Pl00ff0000ec303030N#%=%(%#Plec303030ec303030N#%(%#Plf79e9e9eec303030N#\ %{&fileformat}\ %)%)%(%#Plf79e9e9eec303030N#│%(%#Plf79e9e9eec303030N#\ %{(&fenc\ ==\ \"\"\ ?\ &enc\ :\ &fenc)}\ %)%)%(%#Plf79e9e9eec303030N#│%(%#Plf79e9e9eec303030N#\ %{strlen(&ft)\ ?\ &ft\ :\ \"no\ ft\"}\ %)%)%(%#Plf0585858ec303030N#%(%#Plfabcbcbcf0585858N#\ %3p%%\ %)%)%(%#Plfcd0d0d0f0585858b#%(%#Plec303030fcd0d0d0b#\ LN\ %3l%)%(%#Plf4808080fcd0d0d0N#\ C\ %-2c%)\ %)',\ 'n':\ '%(%(%#Pl16005f0094afd700b#\ %{Powerline#Functions#GetMode()}\ %)%#Pl94afd700f0585858b#%)%(\ %(%#Plc4ff0000f0585858b#%{&readonly\ ?\ \"RO\"\ :\ \"\"}\ %)%(%#Ple7fffffff0585858b#%t\ %)%(%#Plc4ff0000f0585858b#%M\ %)%(%#Plc4ff0000f0585858b#%H%W\ %)%#Plf0585858ec303030b#%)%<%#Pl00ff0000ec303030N#%=%(%#Plec303030ec303030N#%(%#Plf79e9e9eec303030N#\ %{&fileformat}\ %)%)%(%#Plf79e9e9eec303030N#│%(%#Plf79e9e9eec303030N#\ %{(&fenc\ ==\ \"\"\ ?\ &enc\ :\ &fenc)}\ %)%)%(%#Plf79e9e9eec303030N#│%(%#Plf79e9e9eec303030N#\ %{strlen(&ft)\ ?\ &ft\ :\ \"no\ ft\"}\ %)%)%(%#Plf0585858ec303030N#%(%#Plfabcbcbcf0585858N#\ %3p%%\ %)%)%(%#Plfcd0d0d0f0585858b#%(%#Plec303030fcd0d0d0b#\ LN\ %3l%)%(%#Plf4808080fcd0d0d0N#\ C\ %-2c%)\ %)',\ 'v':\ '%(%(%#Pl58870000d0ff8700b#\ %{Powerline#Functions#GetMode()}\ %)%#Pld0ff8700f0585858b#%)%(\ %(%#Plc4ff0000f0585858b#%{&readonly\ ?\ \"RO\"\ :\ \"\"}\ %)%(%#Ple7fffffff0585858b#%t\ %)%(%#Plc4ff0000f0585858b#%M\ %)%(%#Plc4ff0000f0585858b#%H%W\ %)%#Plf0585858ec303030b#%)%<%#Pl00ff0000ec303030N#%=%(%#Plec303030ec303030N#%(%#Plf79e9e9eec303030N#\ %{&fileformat}\ %)%)%(%#Plf79e9e9eec303030N#│%(%#Plf79e9e9eec303030N#\ %{(&fenc\ ==\ \"\"\ ?\ &enc\ :\ &fenc)}\ %)%)%(%#Plf79e9e9eec303030N#│%(%#Plf79e9e9eec303030N#\ %{strlen(&ft)\ ?\ &ft\ :\ \"no\ ft\"}\ %)%)%(%#Plf0585858ec303030N#%(%#Plfabcbcbcf0585858N#\ %3p%%\ %)%)%(%#Plfcd0d0d0f0585858b#%(%#Plec303030fcd0d0d0b#\ LN\ %3l%)%(%#Plf4808080fcd0d0d0N#\ C\ %-2c%)\ %)',\ 'i':\ '%(%(%#Pl17005f5fe7ffffffb#\ %{Powerline#Functions#GetMode()}\ %)%#Ple7ffffff1f0087afb#%)%(\ %(%#Plc4ff00001f0087afb#%{&readonly\ ?\ \"RO\"\ :\ \"\"}\ %)%(%#Ple7ffffff1f0087afb#%t\ %)%(%#Plc4ff00001f0087afb#%M\ %)%(%#Plc4ff00001f0087afb#%H%W\ %)%#Pl1f0087af18005f87b#%)%<%#Pl00ff000018005f87N#%=%(%#Pl18005f8718005f87N#%(%#Pl7587d7ff18005f87N#\ %{&fileformat}\ %)%)%(%#Pl7587d7ff18005f87N#│%(%#Pl7587d7ff18005f87N#\ %{(&fenc\ ==\ \"\"\ ?\ &enc\ :\ &fenc)}\ %)%)%(%#Pl7587d7ff18005f87N#│%(%#Pl7587d7ff18005f87N#\ %{strlen(&ft)\ ?\ &ft\ :\ \"no\ ft\"}\ %)%)%(%#Pl1f0087af18005f87N#%(%#Pl7587d7ff1f0087afN#\ %3p%%\ %)%)%(%#Pl7587d7ff1f0087afb#%(%#Pl17005f5f7587d7ffb#\ LN\ %3l%)%(%#Pl17005f5f7587d7ffN#\ C\ %-2c%)\ %)',\ 'N':\ '%(\ %(%#Pl58870000eb262626N#%{&readonly\ ?\ \"RO\"\ :\ \"\"}\ %)%(%#Plf58a8a8aeb262626b#%t\ %)%(%#Pl58870000eb262626N#%M\ %)%(%#Pl58870000eb262626N#%H%W\ %)%#Pleb262626e9121212b#%)%<%#Pl00ff0000e9121212N#%=%(%#Pleb262626e9121212N#%(%#Plef4e4e4eeb262626N#\ %3p%%\ %)%)%(%#Plf58a8a8aeb262626b#│%(%#Plf58a8a8aeb262626b#\ LN\ %3l%)%(%#Plf1626262eb262626N#\ C\ %-2c%)\ %)'},0)
setlocal suffixesadd=.java
setlocal swapfile
setlocal synmaxcol=3000
if &syntax != 'java'
setlocal syntax=java
endif
setlocal tabstop=4
setlocal tags=
setlocal textwidth=0
setlocal thesaurus=
setlocal noundofile
setlocal nowinfixheight
setlocal nowinfixwidth
setlocal wrap
setlocal wrapmargin=0
silent! normal! zE
let s:l = 17 - ((16 * winheight(0) + 30) / 61)
if s:l < 1 | let s:l = 1 | endif
exe s:l
normal! zt
17
normal! 010l
tabedit src/fr/miblack/chess/Play.java
set splitbelow splitright
set nosplitbelow
set nosplitright
wincmd t
set winheight=1 winwidth=1
argglobal
nnoremap <buffer> <silent> ,jd :call VjdeGetDocUnderCursor()
nnoremap <buffer> <silent> ,as :call VjdeAppendTemplate("Singleton")
nnoremap <buffer> <silent> ,ii :call VjdeImplementInner()
nnoremap <buffer> <silent> ,oi :call Vjde_override(1)
nnoremap <buffer> <silent> ,oe :call Vjde_override(0)
vnoremap <buffer> <silent> ,en :call Vjde_rft_const()
nnoremap <buffer> <silent> ,ep :call Vjde_rft_arg()
nnoremap <buffer> <silent> ,em :call Vjde_rft_var(1)
nnoremap <buffer> <silent> ,el :call Vjde_rft_var(2)
nnoremap <buffer> <silent> ,ri :call Vjde_remove_imports()
nnoremap <buffer> <silent> ,ai :call Vjde_fix_import1()
nnoremap <buffer> <silent> ,fi :call Vjde_fix_import()
nnoremap <buffer> <silent> ,ft :call Vjde_fix_try()
nnoremap <buffer> <silent> ,fr :call Vjde_fix_throws()
vnoremap <buffer> <silent> ,js :call Vjde_sort_import()
vnoremap <buffer> <silent> ,jt :call Vjde_surround_try()
nnoremap <buffer> <silent> ,jt :call Vjde_surround_try()
nnoremap <buffer> <silent> ,jc :call VjdeGenerateConstructor()
nnoremap <buffer> <silent> ,jg :call Vjde_get_set()
nnoremap <buffer> <silent> ,je :call Vjde_ext_import()
inoreabbr <buffer> logger logger=eclim#java#logging#LoggingInit("logger")
inoreabbr <buffer> log log=eclim#java#logging#LoggingInit("log")
setlocal keymap=
setlocal noarabic
setlocal autoindent
setlocal nobinary
setlocal bufhidden=
setlocal buflisted
setlocal buftype=
setlocal cindent
setlocal cinkeys=0{,0},0),:,0#,!^F,o,O,e
setlocal cinoptions=j1
setlocal cinwords=if,else,while,do,for,switch
setlocal colorcolumn=
setlocal comments=sO:*\ -,mO:*\ \ ,exO:*/,s1:/*,mb:*,ex:*/,://,b:#,:%,:XCOMM,n:>,fb:-
setlocal commentstring=//%s
setlocal complete=.,w,b,u,t,i
setlocal concealcursor=
setlocal conceallevel=0
setlocal completefunc=VjdeCompletionFun0
setlocal nocopyindent
setlocal cryptmethod=
setlocal nocursorbind
setlocal nocursorcolumn
setlocal nocursorline
setlocal define=
setlocal dictionary=
setlocal nodiff
setlocal equalprg=
setlocal errorformat=%E%f:%l:\ %m,%-Z%p^,%-C%.%#,%-G%.%#
setlocal noexpandtab
if &filetype != 'java'
setlocal filetype=java
endif
setlocal foldcolumn=0
setlocal foldenable
setlocal foldexpr=0
setlocal foldignore=#
setlocal foldlevel=0
setlocal foldmarker={{{,}}}
setlocal foldmethod=manual
setlocal foldminlines=1
setlocal foldnestmax=20
setlocal foldtext=foldtext()
setlocal formatexpr=
setlocal formatoptions=croql
setlocal formatlistpat=^\\s*\\d\\+[\\]:.)}\\t\ ]\\s*
setlocal grepprg=
setlocal iminsert=0
setlocal imsearch=0
setlocal include=^s*import
setlocal includeexpr=substitute(v:fname,'\\.','/','g')
setlocal indentexpr=GetJavaIndent()
setlocal indentkeys=0{,0},:,0#,!^F,o,O,e,0=extends,0=implements
setlocal noinfercase
setlocal iskeyword=@,48-57,_,192-255
setlocal keywordprg=
setlocal nolinebreak
setlocal nolisp
setlocal nolist
setlocal makeprg=javac
setlocal matchpairs=(:),{:},[:]
setlocal modeline
setlocal modifiable
setlocal nrformats=octal,hex
set number
setlocal number
setlocal numberwidth=4
setlocal omnifunc=javacomplete#Complete
setlocal path=
setlocal nopreserveindent
setlocal nopreviewwindow
setlocal quoteescape=\\
setlocal noreadonly
setlocal norelativenumber
setlocal norightleft
setlocal rightleftcmd=search
setlocal noscrollbind
setlocal shiftwidth=4
setlocal noshortname
setlocal smartindent
setlocal softtabstop=0
setlocal nospell
setlocal spellcapcheck=[.?!]\\_[\\])'\"\	\ ]\\+
setlocal spellfile=
setlocal spelllang=fr,en
setlocal statusline=%!Pl#Statusline({'r':\ '%(%(%#Ple7ffffffa0d70000b#\ %{Powerline#Functions#GetMode()}\ %)%#Pla0d70000f0585858b#%)%(\ %(%#Plc4ff0000f0585858b#%{&readonly\ ?\ \"RO\"\ :\ \"\"}\ %)%(%#Ple7fffffff0585858b#%t\ %)%(%#Plc4ff0000f0585858b#%M\ %)%(%#Plc4ff0000f0585858b#%H%W\ %)%#Plf0585858ec303030b#%)%<%#Pl00ff0000ec303030N#%=%(%#Plec303030ec303030N#%(%#Plf79e9e9eec303030N#\ %{&fileformat}\ %)%)%(%#Plf79e9e9eec303030N#│%(%#Plf79e9e9eec303030N#\ %{(&fenc\ ==\ \"\"\ ?\ &enc\ :\ &fenc)}\ %)%)%(%#Plf79e9e9eec303030N#│%(%#Plf79e9e9eec303030N#\ %{strlen(&ft)\ ?\ &ft\ :\ \"no\ ft\"}\ %)%)%(%#Plf0585858ec303030N#%(%#Plfabcbcbcf0585858N#\ %3p%%\ %)%)%(%#Plfcd0d0d0f0585858b#%(%#Plec303030fcd0d0d0b#\ LN\ %3l%)%(%#Plf4808080fcd0d0d0N#\ C\ %-2c%)\ %)',\ 'n':\ '%(%(%#Pl16005f0094afd700b#\ %{Powerline#Functions#GetMode()}\ %)%#Pl94afd700f0585858b#%)%(\ %(%#Plc4ff0000f0585858b#%{&readonly\ ?\ \"RO\"\ :\ \"\"}\ %)%(%#Ple7fffffff0585858b#%t\ %)%(%#Plc4ff0000f0585858b#%M\ %)%(%#Plc4ff0000f0585858b#%H%W\ %)%#Plf0585858ec303030b#%)%<%#Pl00ff0000ec303030N#%=%(%#Plec303030ec303030N#%(%#Plf79e9e9eec303030N#\ %{&fileformat}\ %)%)%(%#Plf79e9e9eec303030N#│%(%#Plf79e9e9eec303030N#\ %{(&fenc\ ==\ \"\"\ ?\ &enc\ :\ &fenc)}\ %)%)%(%#Plf79e9e9eec303030N#│%(%#Plf79e9e9eec303030N#\ %{strlen(&ft)\ ?\ &ft\ :\ \"no\ ft\"}\ %)%)%(%#Plf0585858ec303030N#%(%#Plfabcbcbcf0585858N#\ %3p%%\ %)%)%(%#Plfcd0d0d0f0585858b#%(%#Plec303030fcd0d0d0b#\ LN\ %3l%)%(%#Plf4808080fcd0d0d0N#\ C\ %-2c%)\ %)',\ 'v':\ '%(%(%#Pl58870000d0ff8700b#\ %{Powerline#Functions#GetMode()}\ %)%#Pld0ff8700f0585858b#%)%(\ %(%#Plc4ff0000f0585858b#%{&readonly\ ?\ \"RO\"\ :\ \"\"}\ %)%(%#Ple7fffffff0585858b#%t\ %)%(%#Plc4ff0000f0585858b#%M\ %)%(%#Plc4ff0000f0585858b#%H%W\ %)%#Plf0585858ec303030b#%)%<%#Pl00ff0000ec303030N#%=%(%#Plec303030ec303030N#%(%#Plf79e9e9eec303030N#\ %{&fileformat}\ %)%)%(%#Plf79e9e9eec303030N#│%(%#Plf79e9e9eec303030N#\ %{(&fenc\ ==\ \"\"\ ?\ &enc\ :\ &fenc)}\ %)%)%(%#Plf79e9e9eec303030N#│%(%#Plf79e9e9eec303030N#\ %{strlen(&ft)\ ?\ &ft\ :\ \"no\ ft\"}\ %)%)%(%#Plf0585858ec303030N#%(%#Plfabcbcbcf0585858N#\ %3p%%\ %)%)%(%#Plfcd0d0d0f0585858b#%(%#Plec303030fcd0d0d0b#\ LN\ %3l%)%(%#Plf4808080fcd0d0d0N#\ C\ %-2c%)\ %)',\ 'i':\ '%(%(%#Pl17005f5fe7ffffffb#\ %{Powerline#Functions#GetMode()}\ %)%#Ple7ffffff1f0087afb#%)%(\ %(%#Plc4ff00001f0087afb#%{&readonly\ ?\ \"RO\"\ :\ \"\"}\ %)%(%#Ple7ffffff1f0087afb#%t\ %)%(%#Plc4ff00001f0087afb#%M\ %)%(%#Plc4ff00001f0087afb#%H%W\ %)%#Pl1f0087af18005f87b#%)%<%#Pl00ff000018005f87N#%=%(%#Pl18005f8718005f87N#%(%#Pl7587d7ff18005f87N#\ %{&fileformat}\ %)%)%(%#Pl7587d7ff18005f87N#│%(%#Pl7587d7ff18005f87N#\ %{(&fenc\ ==\ \"\"\ ?\ &enc\ :\ &fenc)}\ %)%)%(%#Pl7587d7ff18005f87N#│%(%#Pl7587d7ff18005f87N#\ %{strlen(&ft)\ ?\ &ft\ :\ \"no\ ft\"}\ %)%)%(%#Pl1f0087af18005f87N#%(%#Pl7587d7ff1f0087afN#\ %3p%%\ %)%)%(%#Pl7587d7ff1f0087afb#%(%#Pl17005f5f7587d7ffb#\ LN\ %3l%)%(%#Pl17005f5f7587d7ffN#\ C\ %-2c%)\ %)',\ 'N':\ '%(\ %(%#Pl58870000eb262626N#%{&readonly\ ?\ \"RO\"\ :\ \"\"}\ %)%(%#Plf58a8a8aeb262626b#%t\ %)%(%#Pl58870000eb262626N#%M\ %)%(%#Pl58870000eb262626N#%H%W\ %)%#Pleb262626e9121212b#%)%<%#Pl00ff0000e9121212N#%=%(%#Pleb262626e9121212N#%(%#Plef4e4e4eeb262626N#\ %3p%%\ %)%)%(%#Plf58a8a8aeb262626b#│%(%#Plf58a8a8aeb262626b#\ LN\ %3l%)%(%#Plf1626262eb262626N#\ C\ %-2c%)\ %)'},0)
setlocal suffixesadd=.java
setlocal swapfile
setlocal synmaxcol=3000
if &syntax != 'java'
setlocal syntax=java
endif
setlocal tabstop=4
setlocal tags=
setlocal textwidth=0
setlocal thesaurus=
setlocal noundofile
setlocal nowinfixheight
setlocal nowinfixwidth
setlocal wrap
setlocal wrapmargin=0
silent! normal! zE
let s:l = 2 - ((1 * winheight(0) + 30) / 61)
if s:l < 1 | let s:l = 1 | endif
exe s:l
normal! zt
2
normal! 0
tabedit src/fr/miblack/chess/Move.java
set splitbelow splitright
set nosplitbelow
set nosplitright
wincmd t
set winheight=1 winwidth=1
argglobal
nnoremap <buffer> <silent> ,jd :call VjdeGetDocUnderCursor()
nnoremap <buffer> <silent> ,as :call VjdeAppendTemplate("Singleton")
nnoremap <buffer> <silent> ,ii :call VjdeImplementInner()
nnoremap <buffer> <silent> ,oi :call Vjde_override(1)
nnoremap <buffer> <silent> ,oe :call Vjde_override(0)
vnoremap <buffer> <silent> ,en :call Vjde_rft_const()
nnoremap <buffer> <silent> ,ep :call Vjde_rft_arg()
nnoremap <buffer> <silent> ,em :call Vjde_rft_var(1)
nnoremap <buffer> <silent> ,el :call Vjde_rft_var(2)
nnoremap <buffer> <silent> ,ri :call Vjde_remove_imports()
nnoremap <buffer> <silent> ,ai :call Vjde_fix_import1()
nnoremap <buffer> <silent> ,fi :call Vjde_fix_import()
nnoremap <buffer> <silent> ,ft :call Vjde_fix_try()
nnoremap <buffer> <silent> ,fr :call Vjde_fix_throws()
vnoremap <buffer> <silent> ,js :call Vjde_sort_import()
vnoremap <buffer> <silent> ,jt :call Vjde_surround_try()
nnoremap <buffer> <silent> ,jt :call Vjde_surround_try()
nnoremap <buffer> <silent> ,jc :call VjdeGenerateConstructor()
nnoremap <buffer> <silent> ,jg :call Vjde_get_set()
nnoremap <buffer> <silent> ,je :call Vjde_ext_import()
inoreabbr <buffer> logger logger=eclim#java#logging#LoggingInit("logger")
inoreabbr <buffer> log log=eclim#java#logging#LoggingInit("log")
setlocal keymap=
setlocal noarabic
setlocal autoindent
setlocal nobinary
setlocal bufhidden=
setlocal buflisted
setlocal buftype=
setlocal cindent
setlocal cinkeys=0{,0},0),:,0#,!^F,o,O,e
setlocal cinoptions=j1
setlocal cinwords=if,else,while,do,for,switch
setlocal colorcolumn=
setlocal comments=sO:*\ -,mO:*\ \ ,exO:*/,s1:/*,mb:*,ex:*/,://,b:#,:%,:XCOMM,n:>,fb:-
setlocal commentstring=//%s
setlocal complete=.,w,b,u,t,i
setlocal concealcursor=
setlocal conceallevel=0
setlocal completefunc=VjdeCompletionFun0
setlocal nocopyindent
setlocal cryptmethod=
setlocal nocursorbind
setlocal nocursorcolumn
setlocal nocursorline
setlocal define=
setlocal dictionary=
setlocal nodiff
setlocal equalprg=
setlocal errorformat=%E%f:%l:\ %m,%-Z%p^,%-C%.%#,%-G%.%#
setlocal noexpandtab
if &filetype != 'java'
setlocal filetype=java
endif
setlocal foldcolumn=0
setlocal foldenable
setlocal foldexpr=0
setlocal foldignore=#
setlocal foldlevel=0
setlocal foldmarker={{{,}}}
setlocal foldmethod=manual
setlocal foldminlines=1
setlocal foldnestmax=20
setlocal foldtext=foldtext()
setlocal formatexpr=
setlocal formatoptions=croql
setlocal formatlistpat=^\\s*\\d\\+[\\]:.)}\\t\ ]\\s*
setlocal grepprg=
setlocal iminsert=0
setlocal imsearch=0
setlocal include=^s*import
setlocal includeexpr=substitute(v:fname,'\\.','/','g')
setlocal indentexpr=GetJavaIndent()
setlocal indentkeys=0{,0},:,0#,!^F,o,O,e,0=extends,0=implements
setlocal noinfercase
setlocal iskeyword=@,48-57,_,192-255
setlocal keywordprg=
setlocal nolinebreak
setlocal nolisp
setlocal nolist
setlocal makeprg=javac
setlocal matchpairs=(:),{:},[:]
setlocal modeline
setlocal modifiable
setlocal nrformats=octal,hex
set number
setlocal number
setlocal numberwidth=4
setlocal omnifunc=javacomplete#Complete
setlocal path=
setlocal nopreserveindent
setlocal nopreviewwindow
setlocal quoteescape=\\
setlocal noreadonly
setlocal norelativenumber
setlocal norightleft
setlocal rightleftcmd=search
setlocal noscrollbind
setlocal shiftwidth=4
setlocal noshortname
setlocal smartindent
setlocal softtabstop=0
setlocal nospell
setlocal spellcapcheck=[.?!]\\_[\\])'\"\	\ ]\\+
setlocal spellfile=
setlocal spelllang=fr,en
setlocal statusline=%!Pl#Statusline({'r':\ '%(%(%#Ple7ffffffa0d70000b#\ %{Powerline#Functions#GetMode()}\ %)%#Pla0d70000f0585858b#%)%(\ %(%#Plc4ff0000f0585858b#%{&readonly\ ?\ \"RO\"\ :\ \"\"}\ %)%(%#Ple7fffffff0585858b#%t\ %)%(%#Plc4ff0000f0585858b#%M\ %)%(%#Plc4ff0000f0585858b#%H%W\ %)%#Plf0585858ec303030b#%)%<%#Pl00ff0000ec303030N#%=%(%#Plec303030ec303030N#%(%#Plf79e9e9eec303030N#\ %{&fileformat}\ %)%)%(%#Plf79e9e9eec303030N#│%(%#Plf79e9e9eec303030N#\ %{(&fenc\ ==\ \"\"\ ?\ &enc\ :\ &fenc)}\ %)%)%(%#Plf79e9e9eec303030N#│%(%#Plf79e9e9eec303030N#\ %{strlen(&ft)\ ?\ &ft\ :\ \"no\ ft\"}\ %)%)%(%#Plf0585858ec303030N#%(%#Plfabcbcbcf0585858N#\ %3p%%\ %)%)%(%#Plfcd0d0d0f0585858b#%(%#Plec303030fcd0d0d0b#\ LN\ %3l%)%(%#Plf4808080fcd0d0d0N#\ C\ %-2c%)\ %)',\ 'n':\ '%(%(%#Pl16005f0094afd700b#\ %{Powerline#Functions#GetMode()}\ %)%#Pl94afd700f0585858b#%)%(\ %(%#Plc4ff0000f0585858b#%{&readonly\ ?\ \"RO\"\ :\ \"\"}\ %)%(%#Ple7fffffff0585858b#%t\ %)%(%#Plc4ff0000f0585858b#%M\ %)%(%#Plc4ff0000f0585858b#%H%W\ %)%#Plf0585858ec303030b#%)%<%#Pl00ff0000ec303030N#%=%(%#Plec303030ec303030N#%(%#Plf79e9e9eec303030N#\ %{&fileformat}\ %)%)%(%#Plf79e9e9eec303030N#│%(%#Plf79e9e9eec303030N#\ %{(&fenc\ ==\ \"\"\ ?\ &enc\ :\ &fenc)}\ %)%)%(%#Plf79e9e9eec303030N#│%(%#Plf79e9e9eec303030N#\ %{strlen(&ft)\ ?\ &ft\ :\ \"no\ ft\"}\ %)%)%(%#Plf0585858ec303030N#%(%#Plfabcbcbcf0585858N#\ %3p%%\ %)%)%(%#Plfcd0d0d0f0585858b#%(%#Plec303030fcd0d0d0b#\ LN\ %3l%)%(%#Plf4808080fcd0d0d0N#\ C\ %-2c%)\ %)',\ 'v':\ '%(%(%#Pl58870000d0ff8700b#\ %{Powerline#Functions#GetMode()}\ %)%#Pld0ff8700f0585858b#%)%(\ %(%#Plc4ff0000f0585858b#%{&readonly\ ?\ \"RO\"\ :\ \"\"}\ %)%(%#Ple7fffffff0585858b#%t\ %)%(%#Plc4ff0000f0585858b#%M\ %)%(%#Plc4ff0000f0585858b#%H%W\ %)%#Plf0585858ec303030b#%)%<%#Pl00ff0000ec303030N#%=%(%#Plec303030ec303030N#%(%#Plf79e9e9eec303030N#\ %{&fileformat}\ %)%)%(%#Plf79e9e9eec303030N#│%(%#Plf79e9e9eec303030N#\ %{(&fenc\ ==\ \"\"\ ?\ &enc\ :\ &fenc)}\ %)%)%(%#Plf79e9e9eec303030N#│%(%#Plf79e9e9eec303030N#\ %{strlen(&ft)\ ?\ &ft\ :\ \"no\ ft\"}\ %)%)%(%#Plf0585858ec303030N#%(%#Plfabcbcbcf0585858N#\ %3p%%\ %)%)%(%#Plfcd0d0d0f0585858b#%(%#Plec303030fcd0d0d0b#\ LN\ %3l%)%(%#Plf4808080fcd0d0d0N#\ C\ %-2c%)\ %)',\ 'i':\ '%(%(%#Pl17005f5fe7ffffffb#\ %{Powerline#Functions#GetMode()}\ %)%#Ple7ffffff1f0087afb#%)%(\ %(%#Plc4ff00001f0087afb#%{&readonly\ ?\ \"RO\"\ :\ \"\"}\ %)%(%#Ple7ffffff1f0087afb#%t\ %)%(%#Plc4ff00001f0087afb#%M\ %)%(%#Plc4ff00001f0087afb#%H%W\ %)%#Pl1f0087af18005f87b#%)%<%#Pl00ff000018005f87N#%=%(%#Pl18005f8718005f87N#%(%#Pl7587d7ff18005f87N#\ %{&fileformat}\ %)%)%(%#Pl7587d7ff18005f87N#│%(%#Pl7587d7ff18005f87N#\ %{(&fenc\ ==\ \"\"\ ?\ &enc\ :\ &fenc)}\ %)%)%(%#Pl7587d7ff18005f87N#│%(%#Pl7587d7ff18005f87N#\ %{strlen(&ft)\ ?\ &ft\ :\ \"no\ ft\"}\ %)%)%(%#Pl1f0087af18005f87N#%(%#Pl7587d7ff1f0087afN#\ %3p%%\ %)%)%(%#Pl7587d7ff1f0087afb#%(%#Pl17005f5f7587d7ffb#\ LN\ %3l%)%(%#Pl17005f5f7587d7ffN#\ C\ %-2c%)\ %)',\ 'N':\ '%(\ %(%#Pl58870000eb262626N#%{&readonly\ ?\ \"RO\"\ :\ \"\"}\ %)%(%#Plf58a8a8aeb262626b#%t\ %)%(%#Pl58870000eb262626N#%M\ %)%(%#Pl58870000eb262626N#%H%W\ %)%#Pleb262626e9121212b#%)%<%#Pl00ff0000e9121212N#%=%(%#Pleb262626e9121212N#%(%#Plef4e4e4eeb262626N#\ %3p%%\ %)%)%(%#Plf58a8a8aeb262626b#│%(%#Plf58a8a8aeb262626b#\ LN\ %3l%)%(%#Plf1626262eb262626N#\ C\ %-2c%)\ %)'},0)
setlocal suffixesadd=.java
setlocal swapfile
setlocal synmaxcol=3000
if &syntax != 'java'
setlocal syntax=java
endif
setlocal tabstop=4
setlocal tags=
setlocal textwidth=0
setlocal thesaurus=
setlocal noundofile
setlocal nowinfixheight
setlocal nowinfixwidth
setlocal wrap
setlocal wrapmargin=0
silent! normal! zE
let s:l = 2 - ((1 * winheight(0) + 30) / 61)
if s:l < 1 | let s:l = 1 | endif
exe s:l
normal! zt
2
normal! 0
tabedit src/fr/miblack/chess/Main.java
set splitbelow splitright
set nosplitbelow
set nosplitright
wincmd t
set winheight=1 winwidth=1
argglobal
nnoremap <buffer> <silent> ,jd :call VjdeGetDocUnderCursor()
nnoremap <buffer> <silent> ,as :call VjdeAppendTemplate("Singleton")
nnoremap <buffer> <silent> ,ii :call VjdeImplementInner()
nnoremap <buffer> <silent> ,oi :call Vjde_override(1)
nnoremap <buffer> <silent> ,oe :call Vjde_override(0)
vnoremap <buffer> <silent> ,en :call Vjde_rft_const()
nnoremap <buffer> <silent> ,ep :call Vjde_rft_arg()
nnoremap <buffer> <silent> ,em :call Vjde_rft_var(1)
nnoremap <buffer> <silent> ,el :call Vjde_rft_var(2)
nnoremap <buffer> <silent> ,ri :call Vjde_remove_imports()
nnoremap <buffer> <silent> ,ai :call Vjde_fix_import1()
nnoremap <buffer> <silent> ,fi :call Vjde_fix_import()
nnoremap <buffer> <silent> ,ft :call Vjde_fix_try()
nnoremap <buffer> <silent> ,fr :call Vjde_fix_throws()
vnoremap <buffer> <silent> ,js :call Vjde_sort_import()
vnoremap <buffer> <silent> ,jt :call Vjde_surround_try()
nnoremap <buffer> <silent> ,jt :call Vjde_surround_try()
nnoremap <buffer> <silent> ,jc :call VjdeGenerateConstructor()
nnoremap <buffer> <silent> ,jg :call Vjde_get_set()
nnoremap <buffer> <silent> ,je :call Vjde_ext_import()
inoreabbr <buffer> logger logger=eclim#java#logging#LoggingInit("logger")
inoreabbr <buffer> log log=eclim#java#logging#LoggingInit("log")
setlocal keymap=
setlocal noarabic
setlocal autoindent
setlocal nobinary
setlocal bufhidden=
setlocal buflisted
setlocal buftype=
setlocal cindent
setlocal cinkeys=0{,0},0),:,0#,!^F,o,O,e
setlocal cinoptions=j1
setlocal cinwords=if,else,while,do,for,switch
setlocal colorcolumn=
setlocal comments=sO:*\ -,mO:*\ \ ,exO:*/,s1:/*,mb:*,ex:*/,://,b:#,:%,:XCOMM,n:>,fb:-
setlocal commentstring=//%s
setlocal complete=.,w,b,u,t,i
setlocal concealcursor=
setlocal conceallevel=0
setlocal completefunc=VjdeCompletionFun0
setlocal nocopyindent
setlocal cryptmethod=
setlocal nocursorbind
setlocal nocursorcolumn
setlocal nocursorline
setlocal define=
setlocal dictionary=
setlocal nodiff
setlocal equalprg=
setlocal errorformat=%E%f:%l:\ %m,%-Z%p^,%-C%.%#,%-G%.%#
setlocal noexpandtab
if &filetype != 'java'
setlocal filetype=java
endif
setlocal foldcolumn=0
setlocal foldenable
setlocal foldexpr=0
setlocal foldignore=#
setlocal foldlevel=0
setlocal foldmarker={{{,}}}
setlocal foldmethod=manual
setlocal foldminlines=1
setlocal foldnestmax=20
setlocal foldtext=foldtext()
setlocal formatexpr=
setlocal formatoptions=croql
setlocal formatlistpat=^\\s*\\d\\+[\\]:.)}\\t\ ]\\s*
setlocal grepprg=
setlocal iminsert=0
setlocal imsearch=0
setlocal include=^s*import
setlocal includeexpr=substitute(v:fname,'\\.','/','g')
setlocal indentexpr=GetJavaIndent()
setlocal indentkeys=0{,0},:,0#,!^F,o,O,e,0=extends,0=implements
setlocal noinfercase
setlocal iskeyword=@,48-57,_,192-255
setlocal keywordprg=
setlocal nolinebreak
setlocal nolisp
setlocal nolist
setlocal makeprg=javac
setlocal matchpairs=(:),{:},[:]
setlocal modeline
setlocal modifiable
setlocal nrformats=octal,hex
set number
setlocal number
setlocal numberwidth=4
setlocal omnifunc=javacomplete#Complete
setlocal path=
setlocal nopreserveindent
setlocal nopreviewwindow
setlocal quoteescape=\\
setlocal noreadonly
setlocal norelativenumber
setlocal norightleft
setlocal rightleftcmd=search
setlocal noscrollbind
setlocal shiftwidth=4
setlocal noshortname
setlocal smartindent
setlocal softtabstop=0
setlocal nospell
setlocal spellcapcheck=[.?!]\\_[\\])'\"\	\ ]\\+
setlocal spellfile=
setlocal spelllang=fr,en
setlocal statusline=%!Pl#Statusline({'r':\ '%(%(%#Ple7ffffffa0d70000b#\ %{Powerline#Functions#GetMode()}\ %)%#Pla0d70000f0585858b#%)%(\ %(%#Plc4ff0000f0585858b#%{&readonly\ ?\ \"RO\"\ :\ \"\"}\ %)%(%#Ple7fffffff0585858b#%t\ %)%(%#Plc4ff0000f0585858b#%M\ %)%(%#Plc4ff0000f0585858b#%H%W\ %)%#Plf0585858ec303030b#%)%<%#Pl00ff0000ec303030N#%=%(%#Plec303030ec303030N#%(%#Plf79e9e9eec303030N#\ %{&fileformat}\ %)%)%(%#Plf79e9e9eec303030N#│%(%#Plf79e9e9eec303030N#\ %{(&fenc\ ==\ \"\"\ ?\ &enc\ :\ &fenc)}\ %)%)%(%#Plf79e9e9eec303030N#│%(%#Plf79e9e9eec303030N#\ %{strlen(&ft)\ ?\ &ft\ :\ \"no\ ft\"}\ %)%)%(%#Plf0585858ec303030N#%(%#Plfabcbcbcf0585858N#\ %3p%%\ %)%)%(%#Plfcd0d0d0f0585858b#%(%#Plec303030fcd0d0d0b#\ LN\ %3l%)%(%#Plf4808080fcd0d0d0N#\ C\ %-2c%)\ %)',\ 'n':\ '%(%(%#Pl16005f0094afd700b#\ %{Powerline#Functions#GetMode()}\ %)%#Pl94afd700f0585858b#%)%(\ %(%#Plc4ff0000f0585858b#%{&readonly\ ?\ \"RO\"\ :\ \"\"}\ %)%(%#Ple7fffffff0585858b#%t\ %)%(%#Plc4ff0000f0585858b#%M\ %)%(%#Plc4ff0000f0585858b#%H%W\ %)%#Plf0585858ec303030b#%)%<%#Pl00ff0000ec303030N#%=%(%#Plec303030ec303030N#%(%#Plf79e9e9eec303030N#\ %{&fileformat}\ %)%)%(%#Plf79e9e9eec303030N#│%(%#Plf79e9e9eec303030N#\ %{(&fenc\ ==\ \"\"\ ?\ &enc\ :\ &fenc)}\ %)%)%(%#Plf79e9e9eec303030N#│%(%#Plf79e9e9eec303030N#\ %{strlen(&ft)\ ?\ &ft\ :\ \"no\ ft\"}\ %)%)%(%#Plf0585858ec303030N#%(%#Plfabcbcbcf0585858N#\ %3p%%\ %)%)%(%#Plfcd0d0d0f0585858b#%(%#Plec303030fcd0d0d0b#\ LN\ %3l%)%(%#Plf4808080fcd0d0d0N#\ C\ %-2c%)\ %)',\ 'v':\ '%(%(%#Pl58870000d0ff8700b#\ %{Powerline#Functions#GetMode()}\ %)%#Pld0ff8700f0585858b#%)%(\ %(%#Plc4ff0000f0585858b#%{&readonly\ ?\ \"RO\"\ :\ \"\"}\ %)%(%#Ple7fffffff0585858b#%t\ %)%(%#Plc4ff0000f0585858b#%M\ %)%(%#Plc4ff0000f0585858b#%H%W\ %)%#Plf0585858ec303030b#%)%<%#Pl00ff0000ec303030N#%=%(%#Plec303030ec303030N#%(%#Plf79e9e9eec303030N#\ %{&fileformat}\ %)%)%(%#Plf79e9e9eec303030N#│%(%#Plf79e9e9eec303030N#\ %{(&fenc\ ==\ \"\"\ ?\ &enc\ :\ &fenc)}\ %)%)%(%#Plf79e9e9eec303030N#│%(%#Plf79e9e9eec303030N#\ %{strlen(&ft)\ ?\ &ft\ :\ \"no\ ft\"}\ %)%)%(%#Plf0585858ec303030N#%(%#Plfabcbcbcf0585858N#\ %3p%%\ %)%)%(%#Plfcd0d0d0f0585858b#%(%#Plec303030fcd0d0d0b#\ LN\ %3l%)%(%#Plf4808080fcd0d0d0N#\ C\ %-2c%)\ %)',\ 'i':\ '%(%(%#Pl17005f5fe7ffffffb#\ %{Powerline#Functions#GetMode()}\ %)%#Ple7ffffff1f0087afb#%)%(\ %(%#Plc4ff00001f0087afb#%{&readonly\ ?\ \"RO\"\ :\ \"\"}\ %)%(%#Ple7ffffff1f0087afb#%t\ %)%(%#Plc4ff00001f0087afb#%M\ %)%(%#Plc4ff00001f0087afb#%H%W\ %)%#Pl1f0087af18005f87b#%)%<%#Pl00ff000018005f87N#%=%(%#Pl18005f8718005f87N#%(%#Pl7587d7ff18005f87N#\ %{&fileformat}\ %)%)%(%#Pl7587d7ff18005f87N#│%(%#Pl7587d7ff18005f87N#\ %{(&fenc\ ==\ \"\"\ ?\ &enc\ :\ &fenc)}\ %)%)%(%#Pl7587d7ff18005f87N#│%(%#Pl7587d7ff18005f87N#\ %{strlen(&ft)\ ?\ &ft\ :\ \"no\ ft\"}\ %)%)%(%#Pl1f0087af18005f87N#%(%#Pl7587d7ff1f0087afN#\ %3p%%\ %)%)%(%#Pl7587d7ff1f0087afb#%(%#Pl17005f5f7587d7ffb#\ LN\ %3l%)%(%#Pl17005f5f7587d7ffN#\ C\ %-2c%)\ %)',\ 'N':\ '%(\ %(%#Pl58870000eb262626N#%{&readonly\ ?\ \"RO\"\ :\ \"\"}\ %)%(%#Plf58a8a8aeb262626b#%t\ %)%(%#Pl58870000eb262626N#%M\ %)%(%#Pl58870000eb262626N#%H%W\ %)%#Pleb262626e9121212b#%)%<%#Pl00ff0000e9121212N#%=%(%#Pleb262626e9121212N#%(%#Plef4e4e4eeb262626N#\ %3p%%\ %)%)%(%#Plf58a8a8aeb262626b#│%(%#Plf58a8a8aeb262626b#\ LN\ %3l%)%(%#Plf1626262eb262626N#\ C\ %-2c%)\ %)'},0)
setlocal suffixesadd=.java
setlocal swapfile
setlocal synmaxcol=3000
if &syntax != 'java'
setlocal syntax=java
endif
setlocal tabstop=4
setlocal tags=
setlocal textwidth=0
setlocal thesaurus=
setlocal noundofile
setlocal nowinfixheight
setlocal nowinfixwidth
setlocal wrap
setlocal wrapmargin=0
silent! normal! zE
let s:l = 4 - ((3 * winheight(0) + 30) / 61)
if s:l < 1 | let s:l = 1 | endif
exe s:l
normal! zt
4
normal! 0
tabedit src/fr/miblack/chess/Game.java
set splitbelow splitright
set nosplitbelow
set nosplitright
wincmd t
set winheight=1 winwidth=1
argglobal
nnoremap <buffer> <silent> ,jd :call VjdeGetDocUnderCursor()
nnoremap <buffer> <silent> ,as :call VjdeAppendTemplate("Singleton")
nnoremap <buffer> <silent> ,ii :call VjdeImplementInner()
nnoremap <buffer> <silent> ,oi :call Vjde_override(1)
nnoremap <buffer> <silent> ,oe :call Vjde_override(0)
vnoremap <buffer> <silent> ,en :call Vjde_rft_const()
nnoremap <buffer> <silent> ,ep :call Vjde_rft_arg()
nnoremap <buffer> <silent> ,em :call Vjde_rft_var(1)
nnoremap <buffer> <silent> ,el :call Vjde_rft_var(2)
nnoremap <buffer> <silent> ,ri :call Vjde_remove_imports()
nnoremap <buffer> <silent> ,ai :call Vjde_fix_import1()
nnoremap <buffer> <silent> ,fi :call Vjde_fix_import()
nnoremap <buffer> <silent> ,ft :call Vjde_fix_try()
nnoremap <buffer> <silent> ,fr :call Vjde_fix_throws()
vnoremap <buffer> <silent> ,js :call Vjde_sort_import()
vnoremap <buffer> <silent> ,jt :call Vjde_surround_try()
nnoremap <buffer> <silent> ,jt :call Vjde_surround_try()
nnoremap <buffer> <silent> ,jc :call VjdeGenerateConstructor()
nnoremap <buffer> <silent> ,jg :call Vjde_get_set()
nnoremap <buffer> <silent> ,je :call Vjde_ext_import()
inoreabbr <buffer> logger logger=eclim#java#logging#LoggingInit("logger")
inoreabbr <buffer> log log=eclim#java#logging#LoggingInit("log")
setlocal keymap=
setlocal noarabic
setlocal autoindent
setlocal nobinary
setlocal bufhidden=
setlocal buflisted
setlocal buftype=
setlocal cindent
setlocal cinkeys=0{,0},0),:,0#,!^F,o,O,e
setlocal cinoptions=j1
setlocal cinwords=if,else,while,do,for,switch
setlocal colorcolumn=
setlocal comments=sO:*\ -,mO:*\ \ ,exO:*/,s1:/*,mb:*,ex:*/,://,b:#,:%,:XCOMM,n:>,fb:-
setlocal commentstring=//%s
setlocal complete=.,w,b,u,t,i
setlocal concealcursor=
setlocal conceallevel=0
setlocal completefunc=VjdeCompletionFun0
setlocal nocopyindent
setlocal cryptmethod=
setlocal nocursorbind
setlocal nocursorcolumn
setlocal nocursorline
setlocal define=
setlocal dictionary=
setlocal nodiff
setlocal equalprg=
setlocal errorformat=%E%f:%l:\ %m,%-Z%p^,%-C%.%#,%-G%.%#
setlocal noexpandtab
if &filetype != 'java'
setlocal filetype=java
endif
setlocal foldcolumn=0
setlocal foldenable
setlocal foldexpr=0
setlocal foldignore=#
setlocal foldlevel=0
setlocal foldmarker={{{,}}}
setlocal foldmethod=manual
setlocal foldminlines=1
setlocal foldnestmax=20
setlocal foldtext=foldtext()
setlocal formatexpr=
setlocal formatoptions=croql
setlocal formatlistpat=^\\s*\\d\\+[\\]:.)}\\t\ ]\\s*
setlocal grepprg=
setlocal iminsert=0
setlocal imsearch=0
setlocal include=^s*import
setlocal includeexpr=substitute(v:fname,'\\.','/','g')
setlocal indentexpr=GetJavaIndent()
setlocal indentkeys=0{,0},:,0#,!^F,o,O,e,0=extends,0=implements
setlocal noinfercase
setlocal iskeyword=@,48-57,_,192-255
setlocal keywordprg=
setlocal nolinebreak
setlocal nolisp
setlocal nolist
setlocal makeprg=javac
setlocal matchpairs=(:),{:},[:]
setlocal modeline
setlocal modifiable
setlocal nrformats=octal,hex
set number
setlocal number
setlocal numberwidth=4
setlocal omnifunc=javacomplete#Complete
setlocal path=
setlocal nopreserveindent
setlocal nopreviewwindow
setlocal quoteescape=\\
setlocal noreadonly
setlocal norelativenumber
setlocal norightleft
setlocal rightleftcmd=search
setlocal noscrollbind
setlocal shiftwidth=4
setlocal noshortname
setlocal smartindent
setlocal softtabstop=0
setlocal nospell
setlocal spellcapcheck=[.?!]\\_[\\])'\"\	\ ]\\+
setlocal spellfile=
setlocal spelllang=fr,en
setlocal statusline=%!Pl#Statusline({'r':\ '%(%(%#Ple7ffffffa0d70000b#\ %{Powerline#Functions#GetMode()}\ %)%#Pla0d70000f0585858b#%)%(\ %(%#Plc4ff0000f0585858b#%{&readonly\ ?\ \"RO\"\ :\ \"\"}\ %)%(%#Ple7fffffff0585858b#%t\ %)%(%#Plc4ff0000f0585858b#%M\ %)%(%#Plc4ff0000f0585858b#%H%W\ %)%#Plf0585858ec303030b#%)%<%#Pl00ff0000ec303030N#%=%(%#Plec303030ec303030N#%(%#Plf79e9e9eec303030N#\ %{&fileformat}\ %)%)%(%#Plf79e9e9eec303030N#│%(%#Plf79e9e9eec303030N#\ %{(&fenc\ ==\ \"\"\ ?\ &enc\ :\ &fenc)}\ %)%)%(%#Plf79e9e9eec303030N#│%(%#Plf79e9e9eec303030N#\ %{strlen(&ft)\ ?\ &ft\ :\ \"no\ ft\"}\ %)%)%(%#Plf0585858ec303030N#%(%#Plfabcbcbcf0585858N#\ %3p%%\ %)%)%(%#Plfcd0d0d0f0585858b#%(%#Plec303030fcd0d0d0b#\ LN\ %3l%)%(%#Plf4808080fcd0d0d0N#\ C\ %-2c%)\ %)',\ 'n':\ '%(%(%#Pl16005f0094afd700b#\ %{Powerline#Functions#GetMode()}\ %)%#Pl94afd700f0585858b#%)%(\ %(%#Plc4ff0000f0585858b#%{&readonly\ ?\ \"RO\"\ :\ \"\"}\ %)%(%#Ple7fffffff0585858b#%t\ %)%(%#Plc4ff0000f0585858b#%M\ %)%(%#Plc4ff0000f0585858b#%H%W\ %)%#Plf0585858ec303030b#%)%<%#Pl00ff0000ec303030N#%=%(%#Plec303030ec303030N#%(%#Plf79e9e9eec303030N#\ %{&fileformat}\ %)%)%(%#Plf79e9e9eec303030N#│%(%#Plf79e9e9eec303030N#\ %{(&fenc\ ==\ \"\"\ ?\ &enc\ :\ &fenc)}\ %)%)%(%#Plf79e9e9eec303030N#│%(%#Plf79e9e9eec303030N#\ %{strlen(&ft)\ ?\ &ft\ :\ \"no\ ft\"}\ %)%)%(%#Plf0585858ec303030N#%(%#Plfabcbcbcf0585858N#\ %3p%%\ %)%)%(%#Plfcd0d0d0f0585858b#%(%#Plec303030fcd0d0d0b#\ LN\ %3l%)%(%#Plf4808080fcd0d0d0N#\ C\ %-2c%)\ %)',\ 'v':\ '%(%(%#Pl58870000d0ff8700b#\ %{Powerline#Functions#GetMode()}\ %)%#Pld0ff8700f0585858b#%)%(\ %(%#Plc4ff0000f0585858b#%{&readonly\ ?\ \"RO\"\ :\ \"\"}\ %)%(%#Ple7fffffff0585858b#%t\ %)%(%#Plc4ff0000f0585858b#%M\ %)%(%#Plc4ff0000f0585858b#%H%W\ %)%#Plf0585858ec303030b#%)%<%#Pl00ff0000ec303030N#%=%(%#Plec303030ec303030N#%(%#Plf79e9e9eec303030N#\ %{&fileformat}\ %)%)%(%#Plf79e9e9eec303030N#│%(%#Plf79e9e9eec303030N#\ %{(&fenc\ ==\ \"\"\ ?\ &enc\ :\ &fenc)}\ %)%)%(%#Plf79e9e9eec303030N#│%(%#Plf79e9e9eec303030N#\ %{strlen(&ft)\ ?\ &ft\ :\ \"no\ ft\"}\ %)%)%(%#Plf0585858ec303030N#%(%#Plfabcbcbcf0585858N#\ %3p%%\ %)%)%(%#Plfcd0d0d0f0585858b#%(%#Plec303030fcd0d0d0b#\ LN\ %3l%)%(%#Plf4808080fcd0d0d0N#\ C\ %-2c%)\ %)',\ 'i':\ '%(%(%#Pl17005f5fe7ffffffb#\ %{Powerline#Functions#GetMode()}\ %)%#Ple7ffffff1f0087afb#%)%(\ %(%#Plc4ff00001f0087afb#%{&readonly\ ?\ \"RO\"\ :\ \"\"}\ %)%(%#Ple7ffffff1f0087afb#%t\ %)%(%#Plc4ff00001f0087afb#%M\ %)%(%#Plc4ff00001f0087afb#%H%W\ %)%#Pl1f0087af18005f87b#%)%<%#Pl00ff000018005f87N#%=%(%#Pl18005f8718005f87N#%(%#Pl7587d7ff18005f87N#\ %{&fileformat}\ %)%)%(%#Pl7587d7ff18005f87N#│%(%#Pl7587d7ff18005f87N#\ %{(&fenc\ ==\ \"\"\ ?\ &enc\ :\ &fenc)}\ %)%)%(%#Pl7587d7ff18005f87N#│%(%#Pl7587d7ff18005f87N#\ %{strlen(&ft)\ ?\ &ft\ :\ \"no\ ft\"}\ %)%)%(%#Pl1f0087af18005f87N#%(%#Pl7587d7ff1f0087afN#\ %3p%%\ %)%)%(%#Pl7587d7ff1f0087afb#%(%#Pl17005f5f7587d7ffb#\ LN\ %3l%)%(%#Pl17005f5f7587d7ffN#\ C\ %-2c%)\ %)',\ 'N':\ '%(\ %(%#Pl58870000eb262626N#%{&readonly\ ?\ \"RO\"\ :\ \"\"}\ %)%(%#Plf58a8a8aeb262626b#%t\ %)%(%#Pl58870000eb262626N#%M\ %)%(%#Pl58870000eb262626N#%H%W\ %)%#Pleb262626e9121212b#%)%<%#Pl00ff0000e9121212N#%=%(%#Pleb262626e9121212N#%(%#Plef4e4e4eeb262626N#\ %3p%%\ %)%)%(%#Plf58a8a8aeb262626b#│%(%#Plf58a8a8aeb262626b#\ LN\ %3l%)%(%#Plf1626262eb262626N#\ C\ %-2c%)\ %)'},0)
setlocal suffixesadd=.java
setlocal swapfile
setlocal synmaxcol=3000
if &syntax != 'java'
setlocal syntax=java
endif
setlocal tabstop=4
setlocal tags=
setlocal textwidth=0
setlocal thesaurus=
setlocal noundofile
setlocal nowinfixheight
setlocal nowinfixwidth
setlocal wrap
setlocal wrapmargin=0
silent! normal! zE
let s:l = 3 - ((2 * winheight(0) + 30) / 61)
if s:l < 1 | let s:l = 1 | endif
exe s:l
normal! zt
3
normal! 018l
tabedit src/fr/miblack/chess/Chessboard.java
set splitbelow splitright
set nosplitbelow
set nosplitright
wincmd t
set winheight=1 winwidth=1
argglobal
nnoremap <buffer> <silent> ,jd :call VjdeGetDocUnderCursor()
nnoremap <buffer> <silent> ,as :call VjdeAppendTemplate("Singleton")
nnoremap <buffer> <silent> ,ii :call VjdeImplementInner()
nnoremap <buffer> <silent> ,oi :call Vjde_override(1)
nnoremap <buffer> <silent> ,oe :call Vjde_override(0)
vnoremap <buffer> <silent> ,en :call Vjde_rft_const()
nnoremap <buffer> <silent> ,ep :call Vjde_rft_arg()
nnoremap <buffer> <silent> ,em :call Vjde_rft_var(1)
nnoremap <buffer> <silent> ,el :call Vjde_rft_var(2)
nnoremap <buffer> <silent> ,ri :call Vjde_remove_imports()
nnoremap <buffer> <silent> ,ai :call Vjde_fix_import1()
nnoremap <buffer> <silent> ,fi :call Vjde_fix_import()
nnoremap <buffer> <silent> ,ft :call Vjde_fix_try()
nnoremap <buffer> <silent> ,fr :call Vjde_fix_throws()
vnoremap <buffer> <silent> ,js :call Vjde_sort_import()
vnoremap <buffer> <silent> ,jt :call Vjde_surround_try()
nnoremap <buffer> <silent> ,jt :call Vjde_surround_try()
nnoremap <buffer> <silent> ,jc :call VjdeGenerateConstructor()
nnoremap <buffer> <silent> ,jg :call Vjde_get_set()
nnoremap <buffer> <silent> ,je :call Vjde_ext_import()
inoreabbr <buffer> logger logger=eclim#java#logging#LoggingInit("logger")
inoreabbr <buffer> log log=eclim#java#logging#LoggingInit("log")
setlocal keymap=
setlocal noarabic
setlocal autoindent
setlocal nobinary
setlocal bufhidden=
setlocal buflisted
setlocal buftype=
setlocal cindent
setlocal cinkeys=0{,0},0),:,0#,!^F,o,O,e
setlocal cinoptions=j1
setlocal cinwords=if,else,while,do,for,switch
setlocal colorcolumn=
setlocal comments=sO:*\ -,mO:*\ \ ,exO:*/,s1:/*,mb:*,ex:*/,://,b:#,:%,:XCOMM,n:>,fb:-
setlocal commentstring=//%s
setlocal complete=.,w,b,u,t,i
setlocal concealcursor=
setlocal conceallevel=0
setlocal completefunc=VjdeCompletionFun0
setlocal nocopyindent
setlocal cryptmethod=
setlocal nocursorbind
setlocal nocursorcolumn
setlocal nocursorline
setlocal define=
setlocal dictionary=
setlocal nodiff
setlocal equalprg=
setlocal errorformat=%E%f:%l:\ %m,%-Z%p^,%-C%.%#,%-G%.%#
setlocal noexpandtab
if &filetype != 'java'
setlocal filetype=java
endif
setlocal foldcolumn=0
setlocal foldenable
setlocal foldexpr=0
setlocal foldignore=#
setlocal foldlevel=0
setlocal foldmarker={{{,}}}
setlocal foldmethod=manual
setlocal foldminlines=1
setlocal foldnestmax=20
setlocal foldtext=foldtext()
setlocal formatexpr=
setlocal formatoptions=croql
setlocal formatlistpat=^\\s*\\d\\+[\\]:.)}\\t\ ]\\s*
setlocal grepprg=
setlocal iminsert=0
setlocal imsearch=0
setlocal include=^s*import
setlocal includeexpr=substitute(v:fname,'\\.','/','g')
setlocal indentexpr=GetJavaIndent()
setlocal indentkeys=0{,0},:,0#,!^F,o,O,e,0=extends,0=implements
setlocal noinfercase
setlocal iskeyword=@,48-57,_,192-255
setlocal keywordprg=
setlocal nolinebreak
setlocal nolisp
setlocal nolist
setlocal makeprg=javac
setlocal matchpairs=(:),{:},[:]
setlocal modeline
setlocal modifiable
setlocal nrformats=octal,hex
set number
setlocal number
setlocal numberwidth=4
setlocal omnifunc=javacomplete#Complete
setlocal path=
setlocal nopreserveindent
setlocal nopreviewwindow
setlocal quoteescape=\\
setlocal noreadonly
setlocal norelativenumber
setlocal norightleft
setlocal rightleftcmd=search
setlocal noscrollbind
setlocal shiftwidth=4
setlocal noshortname
setlocal smartindent
setlocal softtabstop=0
setlocal nospell
setlocal spellcapcheck=[.?!]\\_[\\])'\"\	\ ]\\+
setlocal spellfile=
setlocal spelllang=fr,en
setlocal statusline=%!Pl#Statusline({'r':\ '%(%(%#Ple7ffffffa0d70000b#\ %{Powerline#Functions#GetMode()}\ %)%#Pla0d70000f0585858b#%)%(\ %(%#Plc4ff0000f0585858b#%{&readonly\ ?\ \"RO\"\ :\ \"\"}\ %)%(%#Ple7fffffff0585858b#%t\ %)%(%#Plc4ff0000f0585858b#%M\ %)%(%#Plc4ff0000f0585858b#%H%W\ %)%#Plf0585858ec303030b#%)%<%#Pl00ff0000ec303030N#%=%(%#Plec303030ec303030N#%(%#Plf79e9e9eec303030N#\ %{&fileformat}\ %)%)%(%#Plf79e9e9eec303030N#│%(%#Plf79e9e9eec303030N#\ %{(&fenc\ ==\ \"\"\ ?\ &enc\ :\ &fenc)}\ %)%)%(%#Plf79e9e9eec303030N#│%(%#Plf79e9e9eec303030N#\ %{strlen(&ft)\ ?\ &ft\ :\ \"no\ ft\"}\ %)%)%(%#Plf0585858ec303030N#%(%#Plfabcbcbcf0585858N#\ %3p%%\ %)%)%(%#Plfcd0d0d0f0585858b#%(%#Plec303030fcd0d0d0b#\ LN\ %3l%)%(%#Plf4808080fcd0d0d0N#\ C\ %-2c%)\ %)',\ 'n':\ '%(%(%#Pl16005f0094afd700b#\ %{Powerline#Functions#GetMode()}\ %)%#Pl94afd700f0585858b#%)%(\ %(%#Plc4ff0000f0585858b#%{&readonly\ ?\ \"RO\"\ :\ \"\"}\ %)%(%#Ple7fffffff0585858b#%t\ %)%(%#Plc4ff0000f0585858b#%M\ %)%(%#Plc4ff0000f0585858b#%H%W\ %)%#Plf0585858ec303030b#%)%<%#Pl00ff0000ec303030N#%=%(%#Plec303030ec303030N#%(%#Plf79e9e9eec303030N#\ %{&fileformat}\ %)%)%(%#Plf79e9e9eec303030N#│%(%#Plf79e9e9eec303030N#\ %{(&fenc\ ==\ \"\"\ ?\ &enc\ :\ &fenc)}\ %)%)%(%#Plf79e9e9eec303030N#│%(%#Plf79e9e9eec303030N#\ %{strlen(&ft)\ ?\ &ft\ :\ \"no\ ft\"}\ %)%)%(%#Plf0585858ec303030N#%(%#Plfabcbcbcf0585858N#\ %3p%%\ %)%)%(%#Plfcd0d0d0f0585858b#%(%#Plec303030fcd0d0d0b#\ LN\ %3l%)%(%#Plf4808080fcd0d0d0N#\ C\ %-2c%)\ %)',\ 'v':\ '%(%(%#Pl58870000d0ff8700b#\ %{Powerline#Functions#GetMode()}\ %)%#Pld0ff8700f0585858b#%)%(\ %(%#Plc4ff0000f0585858b#%{&readonly\ ?\ \"RO\"\ :\ \"\"}\ %)%(%#Ple7fffffff0585858b#%t\ %)%(%#Plc4ff0000f0585858b#%M\ %)%(%#Plc4ff0000f0585858b#%H%W\ %)%#Plf0585858ec303030b#%)%<%#Pl00ff0000ec303030N#%=%(%#Plec303030ec303030N#%(%#Plf79e9e9eec303030N#\ %{&fileformat}\ %)%)%(%#Plf79e9e9eec303030N#│%(%#Plf79e9e9eec303030N#\ %{(&fenc\ ==\ \"\"\ ?\ &enc\ :\ &fenc)}\ %)%)%(%#Plf79e9e9eec303030N#│%(%#Plf79e9e9eec303030N#\ %{strlen(&ft)\ ?\ &ft\ :\ \"no\ ft\"}\ %)%)%(%#Plf0585858ec303030N#%(%#Plfabcbcbcf0585858N#\ %3p%%\ %)%)%(%#Plfcd0d0d0f0585858b#%(%#Plec303030fcd0d0d0b#\ LN\ %3l%)%(%#Plf4808080fcd0d0d0N#\ C\ %-2c%)\ %)',\ 'i':\ '%(%(%#Pl17005f5fe7ffffffb#\ %{Powerline#Functions#GetMode()}\ %)%#Ple7ffffff1f0087afb#%)%(\ %(%#Plc4ff00001f0087afb#%{&readonly\ ?\ \"RO\"\ :\ \"\"}\ %)%(%#Ple7ffffff1f0087afb#%t\ %)%(%#Plc4ff00001f0087afb#%M\ %)%(%#Plc4ff00001f0087afb#%H%W\ %)%#Pl1f0087af18005f87b#%)%<%#Pl00ff000018005f87N#%=%(%#Pl18005f8718005f87N#%(%#Pl7587d7ff18005f87N#\ %{&fileformat}\ %)%)%(%#Pl7587d7ff18005f87N#│%(%#Pl7587d7ff18005f87N#\ %{(&fenc\ ==\ \"\"\ ?\ &enc\ :\ &fenc)}\ %)%)%(%#Pl7587d7ff18005f87N#│%(%#Pl7587d7ff18005f87N#\ %{strlen(&ft)\ ?\ &ft\ :\ \"no\ ft\"}\ %)%)%(%#Pl1f0087af18005f87N#%(%#Pl7587d7ff1f0087afN#\ %3p%%\ %)%)%(%#Pl7587d7ff1f0087afb#%(%#Pl17005f5f7587d7ffb#\ LN\ %3l%)%(%#Pl17005f5f7587d7ffN#\ C\ %-2c%)\ %)',\ 'N':\ '%(\ %(%#Pl58870000eb262626N#%{&readonly\ ?\ \"RO\"\ :\ \"\"}\ %)%(%#Plf58a8a8aeb262626b#%t\ %)%(%#Pl58870000eb262626N#%M\ %)%(%#Pl58870000eb262626N#%H%W\ %)%#Pleb262626e9121212b#%)%<%#Pl00ff0000e9121212N#%=%(%#Pleb262626e9121212N#%(%#Plef4e4e4eeb262626N#\ %3p%%\ %)%)%(%#Plf58a8a8aeb262626b#│%(%#Plf58a8a8aeb262626b#\ LN\ %3l%)%(%#Plf1626262eb262626N#\ C\ %-2c%)\ %)'},0)
setlocal suffixesadd=.java
setlocal swapfile
setlocal synmaxcol=3000
if &syntax != 'java'
setlocal syntax=java
endif
setlocal tabstop=4
setlocal tags=
setlocal textwidth=0
setlocal thesaurus=
setlocal noundofile
setlocal nowinfixheight
setlocal nowinfixwidth
setlocal wrap
setlocal wrapmargin=0
silent! normal! zE
let s:l = 14 - ((13 * winheight(0) + 30) / 61)
if s:l < 1 | let s:l = 1 | endif
exe s:l
normal! zt
14
normal! 02l
tabedit src/fr/miblack/chess/piece/Rook.java
set splitbelow splitright
set nosplitbelow
set nosplitright
wincmd t
set winheight=1 winwidth=1
argglobal
nnoremap <buffer> <silent> ,jd :call VjdeGetDocUnderCursor()
nnoremap <buffer> <silent> ,as :call VjdeAppendTemplate("Singleton")
nnoremap <buffer> <silent> ,ii :call VjdeImplementInner()
nnoremap <buffer> <silent> ,oi :call Vjde_override(1)
nnoremap <buffer> <silent> ,oe :call Vjde_override(0)
vnoremap <buffer> <silent> ,en :call Vjde_rft_const()
nnoremap <buffer> <silent> ,ep :call Vjde_rft_arg()
nnoremap <buffer> <silent> ,em :call Vjde_rft_var(1)
nnoremap <buffer> <silent> ,el :call Vjde_rft_var(2)
nnoremap <buffer> <silent> ,ri :call Vjde_remove_imports()
nnoremap <buffer> <silent> ,ai :call Vjde_fix_import1()
nnoremap <buffer> <silent> ,fi :call Vjde_fix_import()
nnoremap <buffer> <silent> ,ft :call Vjde_fix_try()
nnoremap <buffer> <silent> ,fr :call Vjde_fix_throws()
vnoremap <buffer> <silent> ,js :call Vjde_sort_import()
vnoremap <buffer> <silent> ,jt :call Vjde_surround_try()
nnoremap <buffer> <silent> ,jt :call Vjde_surround_try()
nnoremap <buffer> <silent> ,jc :call VjdeGenerateConstructor()
nnoremap <buffer> <silent> ,jg :call Vjde_get_set()
nnoremap <buffer> <silent> ,je :call Vjde_ext_import()
inoreabbr <buffer> logger logger=eclim#java#logging#LoggingInit("logger")
inoreabbr <buffer> log log=eclim#java#logging#LoggingInit("log")
setlocal keymap=
setlocal noarabic
setlocal autoindent
setlocal nobinary
setlocal bufhidden=
setlocal buflisted
setlocal buftype=
setlocal cindent
setlocal cinkeys=0{,0},0),:,0#,!^F,o,O,e
setlocal cinoptions=j1
setlocal cinwords=if,else,while,do,for,switch
setlocal colorcolumn=
setlocal comments=sO:*\ -,mO:*\ \ ,exO:*/,s1:/*,mb:*,ex:*/,://,b:#,:%,:XCOMM,n:>,fb:-
setlocal commentstring=//%s
setlocal complete=.,w,b,u,t,i
setlocal concealcursor=
setlocal conceallevel=0
setlocal completefunc=javacomplete#CompleteParamsInfo
setlocal nocopyindent
setlocal cryptmethod=
setlocal nocursorbind
setlocal nocursorcolumn
setlocal nocursorline
setlocal define=
setlocal dictionary=
setlocal nodiff
setlocal equalprg=
setlocal errorformat=%E%f:%l:\ %m,%-Z%p^,%-C%.%#,%-G%.%#
setlocal noexpandtab
if &filetype != 'java'
setlocal filetype=java
endif
setlocal foldcolumn=0
setlocal foldenable
setlocal foldexpr=0
setlocal foldignore=#
setlocal foldlevel=0
setlocal foldmarker={{{,}}}
setlocal foldmethod=manual
setlocal foldminlines=1
setlocal foldnestmax=20
setlocal foldtext=foldtext()
setlocal formatexpr=
setlocal formatoptions=croql
setlocal formatlistpat=^\\s*\\d\\+[\\]:.)}\\t\ ]\\s*
setlocal grepprg=
setlocal iminsert=0
setlocal imsearch=0
setlocal include=^s*import
setlocal includeexpr=substitute(v:fname,'\\.','/','g')
setlocal indentexpr=GetJavaIndent()
setlocal indentkeys=0{,0},:,0#,!^F,o,O,e,0=extends,0=implements
setlocal noinfercase
setlocal iskeyword=@,48-57,_,192-255
setlocal keywordprg=
setlocal nolinebreak
setlocal nolisp
setlocal nolist
setlocal makeprg=javac
setlocal matchpairs=(:),{:},[:]
setlocal modeline
setlocal modifiable
setlocal nrformats=octal,hex
set number
setlocal number
setlocal numberwidth=4
setlocal omnifunc=javacomplete#Complete
setlocal path=.,**
setlocal nopreserveindent
setlocal nopreviewwindow
setlocal quoteescape=\\
setlocal noreadonly
setlocal norelativenumber
setlocal norightleft
setlocal rightleftcmd=search
setlocal noscrollbind
setlocal shiftwidth=4
setlocal noshortname
setlocal smartindent
setlocal softtabstop=0
setlocal nospell
setlocal spellcapcheck=[.?!]\\_[\\])'\"\	\ ]\\+
setlocal spellfile=
setlocal spelllang=fr,en
setlocal statusline=%!Pl#Statusline({'r':\ '%(%(%#Ple7ffffffa0d70000b#\ %{Powerline#Functions#GetMode()}\ %)%#Pla0d70000f0585858b#%)%(\ %(%#Plc4ff0000f0585858b#%{&readonly\ ?\ \"RO\"\ :\ \"\"}\ %)%(%#Ple7fffffff0585858b#%t\ %)%(%#Plc4ff0000f0585858b#%M\ %)%(%#Plc4ff0000f0585858b#%H%W\ %)%#Plf0585858ec303030b#%)%<%#Pl00ff0000ec303030N#%=%(%#Plec303030ec303030N#%(%#Plf79e9e9eec303030N#\ %{&fileformat}\ %)%)%(%#Plf79e9e9eec303030N#│%(%#Plf79e9e9eec303030N#\ %{(&fenc\ ==\ \"\"\ ?\ &enc\ :\ &fenc)}\ %)%)%(%#Plf79e9e9eec303030N#│%(%#Plf79e9e9eec303030N#\ %{strlen(&ft)\ ?\ &ft\ :\ \"no\ ft\"}\ %)%)%(%#Plf0585858ec303030N#%(%#Plfabcbcbcf0585858N#\ %3p%%\ %)%)%(%#Plfcd0d0d0f0585858b#%(%#Plec303030fcd0d0d0b#\ LN\ %3l%)%(%#Plf4808080fcd0d0d0N#\ C\ %-2c%)\ %)',\ 'n':\ '%(%(%#Pl16005f0094afd700b#\ %{Powerline#Functions#GetMode()}\ %)%#Pl94afd700f0585858b#%)%(\ %(%#Plc4ff0000f0585858b#%{&readonly\ ?\ \"RO\"\ :\ \"\"}\ %)%(%#Ple7fffffff0585858b#%t\ %)%(%#Plc4ff0000f0585858b#%M\ %)%(%#Plc4ff0000f0585858b#%H%W\ %)%#Plf0585858ec303030b#%)%<%#Pl00ff0000ec303030N#%=%(%#Plec303030ec303030N#%(%#Plf79e9e9eec303030N#\ %{&fileformat}\ %)%)%(%#Plf79e9e9eec303030N#│%(%#Plf79e9e9eec303030N#\ %{(&fenc\ ==\ \"\"\ ?\ &enc\ :\ &fenc)}\ %)%)%(%#Plf79e9e9eec303030N#│%(%#Plf79e9e9eec303030N#\ %{strlen(&ft)\ ?\ &ft\ :\ \"no\ ft\"}\ %)%)%(%#Plf0585858ec303030N#%(%#Plfabcbcbcf0585858N#\ %3p%%\ %)%)%(%#Plfcd0d0d0f0585858b#%(%#Plec303030fcd0d0d0b#\ LN\ %3l%)%(%#Plf4808080fcd0d0d0N#\ C\ %-2c%)\ %)',\ 'v':\ '%(%(%#Pl58870000d0ff8700b#\ %{Powerline#Functions#GetMode()}\ %)%#Pld0ff8700f0585858b#%)%(\ %(%#Plc4ff0000f0585858b#%{&readonly\ ?\ \"RO\"\ :\ \"\"}\ %)%(%#Ple7fffffff0585858b#%t\ %)%(%#Plc4ff0000f0585858b#%M\ %)%(%#Plc4ff0000f0585858b#%H%W\ %)%#Plf0585858ec303030b#%)%<%#Pl00ff0000ec303030N#%=%(%#Plec303030ec303030N#%(%#Plf79e9e9eec303030N#\ %{&fileformat}\ %)%)%(%#Plf79e9e9eec303030N#│%(%#Plf79e9e9eec303030N#\ %{(&fenc\ ==\ \"\"\ ?\ &enc\ :\ &fenc)}\ %)%)%(%#Plf79e9e9eec303030N#│%(%#Plf79e9e9eec303030N#\ %{strlen(&ft)\ ?\ &ft\ :\ \"no\ ft\"}\ %)%)%(%#Plf0585858ec303030N#%(%#Plfabcbcbcf0585858N#\ %3p%%\ %)%)%(%#Plfcd0d0d0f0585858b#%(%#Plec303030fcd0d0d0b#\ LN\ %3l%)%(%#Plf4808080fcd0d0d0N#\ C\ %-2c%)\ %)',\ 'i':\ '%(%(%#Pl17005f5fe7ffffffb#\ %{Powerline#Functions#GetMode()}\ %)%#Ple7ffffff1f0087afb#%)%(\ %(%#Plc4ff00001f0087afb#%{&readonly\ ?\ \"RO\"\ :\ \"\"}\ %)%(%#Ple7ffffff1f0087afb#%t\ %)%(%#Plc4ff00001f0087afb#%M\ %)%(%#Plc4ff00001f0087afb#%H%W\ %)%#Pl1f0087af18005f87b#%)%<%#Pl00ff000018005f87N#%=%(%#Pl18005f8718005f87N#%(%#Pl7587d7ff18005f87N#\ %{&fileformat}\ %)%)%(%#Pl7587d7ff18005f87N#│%(%#Pl7587d7ff18005f87N#\ %{(&fenc\ ==\ \"\"\ ?\ &enc\ :\ &fenc)}\ %)%)%(%#Pl7587d7ff18005f87N#│%(%#Pl7587d7ff18005f87N#\ %{strlen(&ft)\ ?\ &ft\ :\ \"no\ ft\"}\ %)%)%(%#Pl1f0087af18005f87N#%(%#Pl7587d7ff1f0087afN#\ %3p%%\ %)%)%(%#Pl7587d7ff1f0087afb#%(%#Pl17005f5f7587d7ffb#\ LN\ %3l%)%(%#Pl17005f5f7587d7ffN#\ C\ %-2c%)\ %)',\ 'N':\ '%(\ %(%#Pl58870000eb262626N#%{&readonly\ ?\ \"RO\"\ :\ \"\"}\ %)%(%#Plf58a8a8aeb262626b#%t\ %)%(%#Pl58870000eb262626N#%M\ %)%(%#Pl58870000eb262626N#%H%W\ %)%#Pleb262626e9121212b#%)%<%#Pl00ff0000e9121212N#%=%(%#Pleb262626e9121212N#%(%#Plef4e4e4eeb262626N#\ %3p%%\ %)%)%(%#Plf58a8a8aeb262626b#│%(%#Plf58a8a8aeb262626b#\ LN\ %3l%)%(%#Plf1626262eb262626N#\ C\ %-2c%)\ %)'},0)
setlocal suffixesadd=.java
setlocal swapfile
setlocal synmaxcol=3000
if &syntax != 'java'
setlocal syntax=java
endif
setlocal tabstop=4
setlocal tags=
setlocal textwidth=0
setlocal thesaurus=
setlocal noundofile
setlocal nowinfixheight
setlocal nowinfixwidth
setlocal wrap
setlocal wrapmargin=0
silent! normal! zE
let s:l = 1 - ((0 * winheight(0) + 30) / 61)
if s:l < 1 | let s:l = 1 | endif
exe s:l
normal! zt
1
normal! 0
tabedit src/fr/miblack/chess/piece/Queen.java
set splitbelow splitright
set nosplitbelow
set nosplitright
wincmd t
set winheight=1 winwidth=1
argglobal
nnoremap <buffer> <silent> ,jd :call VjdeGetDocUnderCursor()
nnoremap <buffer> <silent> ,as :call VjdeAppendTemplate("Singleton")
nnoremap <buffer> <silent> ,ii :call VjdeImplementInner()
nnoremap <buffer> <silent> ,oi :call Vjde_override(1)
nnoremap <buffer> <silent> ,oe :call Vjde_override(0)
vnoremap <buffer> <silent> ,en :call Vjde_rft_const()
nnoremap <buffer> <silent> ,ep :call Vjde_rft_arg()
nnoremap <buffer> <silent> ,em :call Vjde_rft_var(1)
nnoremap <buffer> <silent> ,el :call Vjde_rft_var(2)
nnoremap <buffer> <silent> ,ri :call Vjde_remove_imports()
nnoremap <buffer> <silent> ,ai :call Vjde_fix_import1()
nnoremap <buffer> <silent> ,fi :call Vjde_fix_import()
nnoremap <buffer> <silent> ,ft :call Vjde_fix_try()
nnoremap <buffer> <silent> ,fr :call Vjde_fix_throws()
vnoremap <buffer> <silent> ,js :call Vjde_sort_import()
vnoremap <buffer> <silent> ,jt :call Vjde_surround_try()
nnoremap <buffer> <silent> ,jt :call Vjde_surround_try()
nnoremap <buffer> <silent> ,jc :call VjdeGenerateConstructor()
nnoremap <buffer> <silent> ,jg :call Vjde_get_set()
nnoremap <buffer> <silent> ,je :call Vjde_ext_import()
inoreabbr <buffer> logger logger=eclim#java#logging#LoggingInit("logger")
inoreabbr <buffer> log log=eclim#java#logging#LoggingInit("log")
setlocal keymap=
setlocal noarabic
setlocal autoindent
setlocal nobinary
setlocal bufhidden=
setlocal buflisted
setlocal buftype=
setlocal cindent
setlocal cinkeys=0{,0},0),:,0#,!^F,o,O,e
setlocal cinoptions=j1
setlocal cinwords=if,else,while,do,for,switch
setlocal colorcolumn=
setlocal comments=sO:*\ -,mO:*\ \ ,exO:*/,s1:/*,mb:*,ex:*/,://,b:#,:%,:XCOMM,n:>,fb:-
setlocal commentstring=//%s
setlocal complete=.,w,b,u,t,i
setlocal concealcursor=
setlocal conceallevel=0
setlocal completefunc=VjdeCompletionFun0
setlocal nocopyindent
setlocal cryptmethod=
setlocal nocursorbind
setlocal nocursorcolumn
setlocal nocursorline
setlocal define=
setlocal dictionary=
setlocal nodiff
setlocal equalprg=
setlocal errorformat=%E%f:%l:\ %m,%-Z%p^,%-C%.%#,%-G%.%#
setlocal noexpandtab
if &filetype != 'java'
setlocal filetype=java
endif
setlocal foldcolumn=0
setlocal foldenable
setlocal foldexpr=0
setlocal foldignore=#
setlocal foldlevel=0
setlocal foldmarker={{{,}}}
setlocal foldmethod=manual
setlocal foldminlines=1
setlocal foldnestmax=20
setlocal foldtext=foldtext()
setlocal formatexpr=
setlocal formatoptions=croql
setlocal formatlistpat=^\\s*\\d\\+[\\]:.)}\\t\ ]\\s*
setlocal grepprg=
setlocal iminsert=0
setlocal imsearch=0
setlocal include=^s*import
setlocal includeexpr=substitute(v:fname,'\\.','/','g')
setlocal indentexpr=GetJavaIndent()
setlocal indentkeys=0{,0},:,0#,!^F,o,O,e,0=extends,0=implements
setlocal noinfercase
setlocal iskeyword=@,48-57,_,192-255
setlocal keywordprg=
setlocal nolinebreak
setlocal nolisp
setlocal nolist
setlocal makeprg=javac
setlocal matchpairs=(:),{:},[:]
setlocal modeline
setlocal modifiable
setlocal nrformats=octal,hex
set number
setlocal number
setlocal numberwidth=4
setlocal omnifunc=javacomplete#Complete
setlocal path=.,**
setlocal nopreserveindent
setlocal nopreviewwindow
setlocal quoteescape=\\
setlocal noreadonly
setlocal norelativenumber
setlocal norightleft
setlocal rightleftcmd=search
setlocal noscrollbind
setlocal shiftwidth=4
setlocal noshortname
setlocal smartindent
setlocal softtabstop=0
setlocal nospell
setlocal spellcapcheck=[.?!]\\_[\\])'\"\	\ ]\\+
setlocal spellfile=
setlocal spelllang=fr,en
setlocal statusline=%!Pl#Statusline({'r':\ '%(%(%#Ple7ffffffa0d70000b#\ %{Powerline#Functions#GetMode()}\ %)%#Pla0d70000f0585858b#%)%(\ %(%#Plc4ff0000f0585858b#%{&readonly\ ?\ \"RO\"\ :\ \"\"}\ %)%(%#Ple7fffffff0585858b#%t\ %)%(%#Plc4ff0000f0585858b#%M\ %)%(%#Plc4ff0000f0585858b#%H%W\ %)%#Plf0585858ec303030b#%)%<%#Pl00ff0000ec303030N#%=%(%#Plec303030ec303030N#%(%#Plf79e9e9eec303030N#\ %{&fileformat}\ %)%)%(%#Plf79e9e9eec303030N#│%(%#Plf79e9e9eec303030N#\ %{(&fenc\ ==\ \"\"\ ?\ &enc\ :\ &fenc)}\ %)%)%(%#Plf79e9e9eec303030N#│%(%#Plf79e9e9eec303030N#\ %{strlen(&ft)\ ?\ &ft\ :\ \"no\ ft\"}\ %)%)%(%#Plf0585858ec303030N#%(%#Plfabcbcbcf0585858N#\ %3p%%\ %)%)%(%#Plfcd0d0d0f0585858b#%(%#Plec303030fcd0d0d0b#\ LN\ %3l%)%(%#Plf4808080fcd0d0d0N#\ C\ %-2c%)\ %)',\ 'n':\ '%(%(%#Pl16005f0094afd700b#\ %{Powerline#Functions#GetMode()}\ %)%#Pl94afd700f0585858b#%)%(\ %(%#Plc4ff0000f0585858b#%{&readonly\ ?\ \"RO\"\ :\ \"\"}\ %)%(%#Ple7fffffff0585858b#%t\ %)%(%#Plc4ff0000f0585858b#%M\ %)%(%#Plc4ff0000f0585858b#%H%W\ %)%#Plf0585858ec303030b#%)%<%#Pl00ff0000ec303030N#%=%(%#Plec303030ec303030N#%(%#Plf79e9e9eec303030N#\ %{&fileformat}\ %)%)%(%#Plf79e9e9eec303030N#│%(%#Plf79e9e9eec303030N#\ %{(&fenc\ ==\ \"\"\ ?\ &enc\ :\ &fenc)}\ %)%)%(%#Plf79e9e9eec303030N#│%(%#Plf79e9e9eec303030N#\ %{strlen(&ft)\ ?\ &ft\ :\ \"no\ ft\"}\ %)%)%(%#Plf0585858ec303030N#%(%#Plfabcbcbcf0585858N#\ %3p%%\ %)%)%(%#Plfcd0d0d0f0585858b#%(%#Plec303030fcd0d0d0b#\ LN\ %3l%)%(%#Plf4808080fcd0d0d0N#\ C\ %-2c%)\ %)',\ 'v':\ '%(%(%#Pl58870000d0ff8700b#\ %{Powerline#Functions#GetMode()}\ %)%#Pld0ff8700f0585858b#%)%(\ %(%#Plc4ff0000f0585858b#%{&readonly\ ?\ \"RO\"\ :\ \"\"}\ %)%(%#Ple7fffffff0585858b#%t\ %)%(%#Plc4ff0000f0585858b#%M\ %)%(%#Plc4ff0000f0585858b#%H%W\ %)%#Plf0585858ec303030b#%)%<%#Pl00ff0000ec303030N#%=%(%#Plec303030ec303030N#%(%#Plf79e9e9eec303030N#\ %{&fileformat}\ %)%)%(%#Plf79e9e9eec303030N#│%(%#Plf79e9e9eec303030N#\ %{(&fenc\ ==\ \"\"\ ?\ &enc\ :\ &fenc)}\ %)%)%(%#Plf79e9e9eec303030N#│%(%#Plf79e9e9eec303030N#\ %{strlen(&ft)\ ?\ &ft\ :\ \"no\ ft\"}\ %)%)%(%#Plf0585858ec303030N#%(%#Plfabcbcbcf0585858N#\ %3p%%\ %)%)%(%#Plfcd0d0d0f0585858b#%(%#Plec303030fcd0d0d0b#\ LN\ %3l%)%(%#Plf4808080fcd0d0d0N#\ C\ %-2c%)\ %)',\ 'i':\ '%(%(%#Pl17005f5fe7ffffffb#\ %{Powerline#Functions#GetMode()}\ %)%#Ple7ffffff1f0087afb#%)%(\ %(%#Plc4ff00001f0087afb#%{&readonly\ ?\ \"RO\"\ :\ \"\"}\ %)%(%#Ple7ffffff1f0087afb#%t\ %)%(%#Plc4ff00001f0087afb#%M\ %)%(%#Plc4ff00001f0087afb#%H%W\ %)%#Pl1f0087af18005f87b#%)%<%#Pl00ff000018005f87N#%=%(%#Pl18005f8718005f87N#%(%#Pl7587d7ff18005f87N#\ %{&fileformat}\ %)%)%(%#Pl7587d7ff18005f87N#│%(%#Pl7587d7ff18005f87N#\ %{(&fenc\ ==\ \"\"\ ?\ &enc\ :\ &fenc)}\ %)%)%(%#Pl7587d7ff18005f87N#│%(%#Pl7587d7ff18005f87N#\ %{strlen(&ft)\ ?\ &ft\ :\ \"no\ ft\"}\ %)%)%(%#Pl1f0087af18005f87N#%(%#Pl7587d7ff1f0087afN#\ %3p%%\ %)%)%(%#Pl7587d7ff1f0087afb#%(%#Pl17005f5f7587d7ffb#\ LN\ %3l%)%(%#Pl17005f5f7587d7ffN#\ C\ %-2c%)\ %)',\ 'N':\ '%(\ %(%#Pl58870000eb262626N#%{&readonly\ ?\ \"RO\"\ :\ \"\"}\ %)%(%#Plf58a8a8aeb262626b#%t\ %)%(%#Pl58870000eb262626N#%M\ %)%(%#Pl58870000eb262626N#%H%W\ %)%#Pleb262626e9121212b#%)%<%#Pl00ff0000e9121212N#%=%(%#Pleb262626e9121212N#%(%#Plef4e4e4eeb262626N#\ %3p%%\ %)%)%(%#Plf58a8a8aeb262626b#│%(%#Plf58a8a8aeb262626b#\ LN\ %3l%)%(%#Plf1626262eb262626N#\ C\ %-2c%)\ %)'},0)
setlocal suffixesadd=.java
setlocal swapfile
setlocal synmaxcol=3000
if &syntax != 'java'
setlocal syntax=java
endif
setlocal tabstop=4
setlocal tags=
setlocal textwidth=0
setlocal thesaurus=
setlocal noundofile
setlocal nowinfixheight
setlocal nowinfixwidth
setlocal wrap
setlocal wrapmargin=0
silent! normal! zE
let s:l = 9 - ((8 * winheight(0) + 30) / 61)
if s:l < 1 | let s:l = 1 | endif
exe s:l
normal! zt
9
normal! 0
tabedit src/fr/miblack/chess/piece/Piece.java
set splitbelow splitright
set nosplitbelow
set nosplitright
wincmd t
set winheight=1 winwidth=1
argglobal
nnoremap <buffer> <silent> ,jd :call VjdeGetDocUnderCursor()
nnoremap <buffer> <silent> ,as :call VjdeAppendTemplate("Singleton")
nnoremap <buffer> <silent> ,ii :call VjdeImplementInner()
nnoremap <buffer> <silent> ,oi :call Vjde_override(1)
nnoremap <buffer> <silent> ,oe :call Vjde_override(0)
vnoremap <buffer> <silent> ,en :call Vjde_rft_const()
nnoremap <buffer> <silent> ,ep :call Vjde_rft_arg()
nnoremap <buffer> <silent> ,em :call Vjde_rft_var(1)
nnoremap <buffer> <silent> ,el :call Vjde_rft_var(2)
nnoremap <buffer> <silent> ,ri :call Vjde_remove_imports()
nnoremap <buffer> <silent> ,ai :call Vjde_fix_import1()
nnoremap <buffer> <silent> ,fi :call Vjde_fix_import()
nnoremap <buffer> <silent> ,ft :call Vjde_fix_try()
nnoremap <buffer> <silent> ,fr :call Vjde_fix_throws()
vnoremap <buffer> <silent> ,js :call Vjde_sort_import()
vnoremap <buffer> <silent> ,jt :call Vjde_surround_try()
nnoremap <buffer> <silent> ,jt :call Vjde_surround_try()
nnoremap <buffer> <silent> ,jc :call VjdeGenerateConstructor()
nnoremap <buffer> <silent> ,jg :call Vjde_get_set()
nnoremap <buffer> <silent> ,je :call Vjde_ext_import()
inoreabbr <buffer> logger logger=eclim#java#logging#LoggingInit("logger")
inoreabbr <buffer> log log=eclim#java#logging#LoggingInit("log")
setlocal keymap=
setlocal noarabic
setlocal autoindent
setlocal nobinary
setlocal bufhidden=
setlocal buflisted
setlocal buftype=
setlocal cindent
setlocal cinkeys=0{,0},0),:,0#,!^F,o,O,e
setlocal cinoptions=j1
setlocal cinwords=if,else,while,do,for,switch
setlocal colorcolumn=
setlocal comments=sO:*\ -,mO:*\ \ ,exO:*/,s1:/*,mb:*,ex:*/,://,b:#,:%,:XCOMM,n:>,fb:-
setlocal commentstring=//%s
setlocal complete=.,w,b,u,t,i
setlocal concealcursor=
setlocal conceallevel=0
setlocal completefunc=VjdeCompletionFun0
setlocal nocopyindent
setlocal cryptmethod=
setlocal nocursorbind
setlocal nocursorcolumn
setlocal nocursorline
setlocal define=
setlocal dictionary=
setlocal nodiff
setlocal equalprg=
setlocal errorformat=%E%f:%l:\ %m,%-Z%p^,%-C%.%#,%-G%.%#
setlocal noexpandtab
if &filetype != 'java'
setlocal filetype=java
endif
setlocal foldcolumn=0
setlocal foldenable
setlocal foldexpr=0
setlocal foldignore=#
setlocal foldlevel=0
setlocal foldmarker={{{,}}}
setlocal foldmethod=manual
setlocal foldminlines=1
setlocal foldnestmax=20
setlocal foldtext=foldtext()
setlocal formatexpr=
setlocal formatoptions=croql
setlocal formatlistpat=^\\s*\\d\\+[\\]:.)}\\t\ ]\\s*
setlocal grepprg=
setlocal iminsert=0
setlocal imsearch=0
setlocal include=^s*import
setlocal includeexpr=substitute(v:fname,'\\.','/','g')
setlocal indentexpr=GetJavaIndent()
setlocal indentkeys=0{,0},:,0#,!^F,o,O,e,0=extends,0=implements
setlocal noinfercase
setlocal iskeyword=@,48-57,_,192-255
setlocal keywordprg=
setlocal nolinebreak
setlocal nolisp
setlocal nolist
setlocal makeprg=javac
setlocal matchpairs=(:),{:},[:]
setlocal modeline
setlocal modifiable
setlocal nrformats=octal,hex
set number
setlocal number
setlocal numberwidth=4
setlocal omnifunc=javacomplete#Complete
setlocal path=.,**
setlocal nopreserveindent
setlocal nopreviewwindow
setlocal quoteescape=\\
setlocal noreadonly
setlocal norelativenumber
setlocal norightleft
setlocal rightleftcmd=search
setlocal noscrollbind
setlocal shiftwidth=4
setlocal noshortname
setlocal smartindent
setlocal softtabstop=0
setlocal nospell
setlocal spellcapcheck=[.?!]\\_[\\])'\"\	\ ]\\+
setlocal spellfile=
setlocal spelllang=fr,en
setlocal statusline=%!Pl#Statusline({'r':\ '%(%(%#Ple7ffffffa0d70000b#\ %{Powerline#Functions#GetMode()}\ %)%#Pla0d70000f0585858b#%)%(\ %(%#Plc4ff0000f0585858b#%{&readonly\ ?\ \"RO\"\ :\ \"\"}\ %)%(%#Ple7fffffff0585858b#%t\ %)%(%#Plc4ff0000f0585858b#%M\ %)%(%#Plc4ff0000f0585858b#%H%W\ %)%#Plf0585858ec303030b#%)%<%#Pl00ff0000ec303030N#%=%(%#Plec303030ec303030N#%(%#Plf79e9e9eec303030N#\ %{&fileformat}\ %)%)%(%#Plf79e9e9eec303030N#│%(%#Plf79e9e9eec303030N#\ %{(&fenc\ ==\ \"\"\ ?\ &enc\ :\ &fenc)}\ %)%)%(%#Plf79e9e9eec303030N#│%(%#Plf79e9e9eec303030N#\ %{strlen(&ft)\ ?\ &ft\ :\ \"no\ ft\"}\ %)%)%(%#Plf0585858ec303030N#%(%#Plfabcbcbcf0585858N#\ %3p%%\ %)%)%(%#Plfcd0d0d0f0585858b#%(%#Plec303030fcd0d0d0b#\ LN\ %3l%)%(%#Plf4808080fcd0d0d0N#\ C\ %-2c%)\ %)',\ 'n':\ '%(%(%#Pl16005f0094afd700b#\ %{Powerline#Functions#GetMode()}\ %)%#Pl94afd700f0585858b#%)%(\ %(%#Plc4ff0000f0585858b#%{&readonly\ ?\ \"RO\"\ :\ \"\"}\ %)%(%#Ple7fffffff0585858b#%t\ %)%(%#Plc4ff0000f0585858b#%M\ %)%(%#Plc4ff0000f0585858b#%H%W\ %)%#Plf0585858ec303030b#%)%<%#Pl00ff0000ec303030N#%=%(%#Plec303030ec303030N#%(%#Plf79e9e9eec303030N#\ %{&fileformat}\ %)%)%(%#Plf79e9e9eec303030N#│%(%#Plf79e9e9eec303030N#\ %{(&fenc\ ==\ \"\"\ ?\ &enc\ :\ &fenc)}\ %)%)%(%#Plf79e9e9eec303030N#│%(%#Plf79e9e9eec303030N#\ %{strlen(&ft)\ ?\ &ft\ :\ \"no\ ft\"}\ %)%)%(%#Plf0585858ec303030N#%(%#Plfabcbcbcf0585858N#\ %3p%%\ %)%)%(%#Plfcd0d0d0f0585858b#%(%#Plec303030fcd0d0d0b#\ LN\ %3l%)%(%#Plf4808080fcd0d0d0N#\ C\ %-2c%)\ %)',\ 'v':\ '%(%(%#Pl58870000d0ff8700b#\ %{Powerline#Functions#GetMode()}\ %)%#Pld0ff8700f0585858b#%)%(\ %(%#Plc4ff0000f0585858b#%{&readonly\ ?\ \"RO\"\ :\ \"\"}\ %)%(%#Ple7fffffff0585858b#%t\ %)%(%#Plc4ff0000f0585858b#%M\ %)%(%#Plc4ff0000f0585858b#%H%W\ %)%#Plf0585858ec303030b#%)%<%#Pl00ff0000ec303030N#%=%(%#Plec303030ec303030N#%(%#Plf79e9e9eec303030N#\ %{&fileformat}\ %)%)%(%#Plf79e9e9eec303030N#│%(%#Plf79e9e9eec303030N#\ %{(&fenc\ ==\ \"\"\ ?\ &enc\ :\ &fenc)}\ %)%)%(%#Plf79e9e9eec303030N#│%(%#Plf79e9e9eec303030N#\ %{strlen(&ft)\ ?\ &ft\ :\ \"no\ ft\"}\ %)%)%(%#Plf0585858ec303030N#%(%#Plfabcbcbcf0585858N#\ %3p%%\ %)%)%(%#Plfcd0d0d0f0585858b#%(%#Plec303030fcd0d0d0b#\ LN\ %3l%)%(%#Plf4808080fcd0d0d0N#\ C\ %-2c%)\ %)',\ 'i':\ '%(%(%#Pl17005f5fe7ffffffb#\ %{Powerline#Functions#GetMode()}\ %)%#Ple7ffffff1f0087afb#%)%(\ %(%#Plc4ff00001f0087afb#%{&readonly\ ?\ \"RO\"\ :\ \"\"}\ %)%(%#Ple7ffffff1f0087afb#%t\ %)%(%#Plc4ff00001f0087afb#%M\ %)%(%#Plc4ff00001f0087afb#%H%W\ %)%#Pl1f0087af18005f87b#%)%<%#Pl00ff000018005f87N#%=%(%#Pl18005f8718005f87N#%(%#Pl7587d7ff18005f87N#\ %{&fileformat}\ %)%)%(%#Pl7587d7ff18005f87N#│%(%#Pl7587d7ff18005f87N#\ %{(&fenc\ ==\ \"\"\ ?\ &enc\ :\ &fenc)}\ %)%)%(%#Pl7587d7ff18005f87N#│%(%#Pl7587d7ff18005f87N#\ %{strlen(&ft)\ ?\ &ft\ :\ \"no\ ft\"}\ %)%)%(%#Pl1f0087af18005f87N#%(%#Pl7587d7ff1f0087afN#\ %3p%%\ %)%)%(%#Pl7587d7ff1f0087afb#%(%#Pl17005f5f7587d7ffb#\ LN\ %3l%)%(%#Pl17005f5f7587d7ffN#\ C\ %-2c%)\ %)',\ 'N':\ '%(\ %(%#Pl58870000eb262626N#%{&readonly\ ?\ \"RO\"\ :\ \"\"}\ %)%(%#Plf58a8a8aeb262626b#%t\ %)%(%#Pl58870000eb262626N#%M\ %)%(%#Pl58870000eb262626N#%H%W\ %)%#Pleb262626e9121212b#%)%<%#Pl00ff0000e9121212N#%=%(%#Pleb262626e9121212N#%(%#Plef4e4e4eeb262626N#\ %3p%%\ %)%)%(%#Plf58a8a8aeb262626b#│%(%#Plf58a8a8aeb262626b#\ LN\ %3l%)%(%#Plf1626262eb262626N#\ C\ %-2c%)\ %)'},0)
setlocal suffixesadd=.java
setlocal swapfile
setlocal synmaxcol=3000
if &syntax != 'java'
setlocal syntax=java
endif
setlocal tabstop=4
setlocal tags=
setlocal textwidth=0
setlocal thesaurus=
setlocal noundofile
setlocal nowinfixheight
setlocal nowinfixwidth
setlocal wrap
setlocal wrapmargin=0
silent! normal! zE
let s:l = 1 - ((0 * winheight(0) + 30) / 61)
if s:l < 1 | let s:l = 1 | endif
exe s:l
normal! zt
1
normal! 0
tabedit src/fr/miblack/chess/piece/Pawn.java
set splitbelow splitright
set nosplitbelow
set nosplitright
wincmd t
set winheight=1 winwidth=1
argglobal
nnoremap <buffer> <silent> ,jd :call VjdeGetDocUnderCursor()
nnoremap <buffer> <silent> ,as :call VjdeAppendTemplate("Singleton")
nnoremap <buffer> <silent> ,ii :call VjdeImplementInner()
nnoremap <buffer> <silent> ,oi :call Vjde_override(1)
nnoremap <buffer> <silent> ,oe :call Vjde_override(0)
vnoremap <buffer> <silent> ,en :call Vjde_rft_const()
nnoremap <buffer> <silent> ,ep :call Vjde_rft_arg()
nnoremap <buffer> <silent> ,em :call Vjde_rft_var(1)
nnoremap <buffer> <silent> ,el :call Vjde_rft_var(2)
nnoremap <buffer> <silent> ,ri :call Vjde_remove_imports()
nnoremap <buffer> <silent> ,ai :call Vjde_fix_import1()
nnoremap <buffer> <silent> ,fi :call Vjde_fix_import()
nnoremap <buffer> <silent> ,ft :call Vjde_fix_try()
nnoremap <buffer> <silent> ,fr :call Vjde_fix_throws()
vnoremap <buffer> <silent> ,js :call Vjde_sort_import()
vnoremap <buffer> <silent> ,jt :call Vjde_surround_try()
nnoremap <buffer> <silent> ,jt :call Vjde_surround_try()
nnoremap <buffer> <silent> ,jc :call VjdeGenerateConstructor()
nnoremap <buffer> <silent> ,jg :call Vjde_get_set()
nnoremap <buffer> <silent> ,je :call Vjde_ext_import()
inoreabbr <buffer> logger logger=eclim#java#logging#LoggingInit("logger")
inoreabbr <buffer> log log=eclim#java#logging#LoggingInit("log")
setlocal keymap=
setlocal noarabic
setlocal autoindent
setlocal nobinary
setlocal bufhidden=
setlocal buflisted
setlocal buftype=
setlocal cindent
setlocal cinkeys=0{,0},0),:,0#,!^F,o,O,e
setlocal cinoptions=j1
setlocal cinwords=if,else,while,do,for,switch
setlocal colorcolumn=
setlocal comments=sO:*\ -,mO:*\ \ ,exO:*/,s1:/*,mb:*,ex:*/,://,b:#,:%,:XCOMM,n:>,fb:-
setlocal commentstring=//%s
setlocal complete=.,w,b,u,t,i
setlocal concealcursor=
setlocal conceallevel=0
setlocal completefunc=VjdeCompletionFun0
setlocal nocopyindent
setlocal cryptmethod=
setlocal nocursorbind
setlocal nocursorcolumn
setlocal nocursorline
setlocal define=
setlocal dictionary=
setlocal nodiff
setlocal equalprg=
setlocal errorformat=%E%f:%l:\ %m,%-Z%p^,%-C%.%#,%-G%.%#
setlocal noexpandtab
if &filetype != 'java'
setlocal filetype=java
endif
setlocal foldcolumn=0
setlocal foldenable
setlocal foldexpr=0
setlocal foldignore=#
setlocal foldlevel=0
setlocal foldmarker={{{,}}}
setlocal foldmethod=manual
setlocal foldminlines=1
setlocal foldnestmax=20
setlocal foldtext=foldtext()
setlocal formatexpr=
setlocal formatoptions=croql
setlocal formatlistpat=^\\s*\\d\\+[\\]:.)}\\t\ ]\\s*
setlocal grepprg=
setlocal iminsert=0
setlocal imsearch=0
setlocal include=^s*import
setlocal includeexpr=substitute(v:fname,'\\.','/','g')
setlocal indentexpr=GetJavaIndent()
setlocal indentkeys=0{,0},:,0#,!^F,o,O,e,0=extends,0=implements
setlocal noinfercase
setlocal iskeyword=@,48-57,_,192-255
setlocal keywordprg=
setlocal nolinebreak
setlocal nolisp
setlocal nolist
setlocal makeprg=javac
setlocal matchpairs=(:),{:},[:]
setlocal modeline
setlocal modifiable
setlocal nrformats=octal,hex
set number
setlocal number
setlocal numberwidth=4
setlocal omnifunc=javacomplete#Complete
setlocal path=
setlocal nopreserveindent
setlocal nopreviewwindow
setlocal quoteescape=\\
setlocal noreadonly
setlocal norelativenumber
setlocal norightleft
setlocal rightleftcmd=search
setlocal noscrollbind
setlocal shiftwidth=4
setlocal noshortname
setlocal smartindent
setlocal softtabstop=0
setlocal nospell
setlocal spellcapcheck=[.?!]\\_[\\])'\"\	\ ]\\+
setlocal spellfile=
setlocal spelllang=fr,en
setlocal statusline=%!Pl#Statusline({'r':\ '%(%(%#Ple7ffffffa0d70000b#\ %{Powerline#Functions#GetMode()}\ %)%#Pla0d70000f0585858b#%)%(\ %(%#Plc4ff0000f0585858b#%{&readonly\ ?\ \"RO\"\ :\ \"\"}\ %)%(%#Ple7fffffff0585858b#%t\ %)%(%#Plc4ff0000f0585858b#%M\ %)%(%#Plc4ff0000f0585858b#%H%W\ %)%#Plf0585858ec303030b#%)%<%#Pl00ff0000ec303030N#%=%(%#Plec303030ec303030N#%(%#Plf79e9e9eec303030N#\ %{&fileformat}\ %)%)%(%#Plf79e9e9eec303030N#│%(%#Plf79e9e9eec303030N#\ %{(&fenc\ ==\ \"\"\ ?\ &enc\ :\ &fenc)}\ %)%)%(%#Plf79e9e9eec303030N#│%(%#Plf79e9e9eec303030N#\ %{strlen(&ft)\ ?\ &ft\ :\ \"no\ ft\"}\ %)%)%(%#Plf0585858ec303030N#%(%#Plfabcbcbcf0585858N#\ %3p%%\ %)%)%(%#Plfcd0d0d0f0585858b#%(%#Plec303030fcd0d0d0b#\ LN\ %3l%)%(%#Plf4808080fcd0d0d0N#\ C\ %-2c%)\ %)',\ 'n':\ '%(%(%#Pl16005f0094afd700b#\ %{Powerline#Functions#GetMode()}\ %)%#Pl94afd700f0585858b#%)%(\ %(%#Plc4ff0000f0585858b#%{&readonly\ ?\ \"RO\"\ :\ \"\"}\ %)%(%#Ple7fffffff0585858b#%t\ %)%(%#Plc4ff0000f0585858b#%M\ %)%(%#Plc4ff0000f0585858b#%H%W\ %)%#Plf0585858ec303030b#%)%<%#Pl00ff0000ec303030N#%=%(%#Plec303030ec303030N#%(%#Plf79e9e9eec303030N#\ %{&fileformat}\ %)%)%(%#Plf79e9e9eec303030N#│%(%#Plf79e9e9eec303030N#\ %{(&fenc\ ==\ \"\"\ ?\ &enc\ :\ &fenc)}\ %)%)%(%#Plf79e9e9eec303030N#│%(%#Plf79e9e9eec303030N#\ %{strlen(&ft)\ ?\ &ft\ :\ \"no\ ft\"}\ %)%)%(%#Plf0585858ec303030N#%(%#Plfabcbcbcf0585858N#\ %3p%%\ %)%)%(%#Plfcd0d0d0f0585858b#%(%#Plec303030fcd0d0d0b#\ LN\ %3l%)%(%#Plf4808080fcd0d0d0N#\ C\ %-2c%)\ %)',\ 'v':\ '%(%(%#Pl58870000d0ff8700b#\ %{Powerline#Functions#GetMode()}\ %)%#Pld0ff8700f0585858b#%)%(\ %(%#Plc4ff0000f0585858b#%{&readonly\ ?\ \"RO\"\ :\ \"\"}\ %)%(%#Ple7fffffff0585858b#%t\ %)%(%#Plc4ff0000f0585858b#%M\ %)%(%#Plc4ff0000f0585858b#%H%W\ %)%#Plf0585858ec303030b#%)%<%#Pl00ff0000ec303030N#%=%(%#Plec303030ec303030N#%(%#Plf79e9e9eec303030N#\ %{&fileformat}\ %)%)%(%#Plf79e9e9eec303030N#│%(%#Plf79e9e9eec303030N#\ %{(&fenc\ ==\ \"\"\ ?\ &enc\ :\ &fenc)}\ %)%)%(%#Plf79e9e9eec303030N#│%(%#Plf79e9e9eec303030N#\ %{strlen(&ft)\ ?\ &ft\ :\ \"no\ ft\"}\ %)%)%(%#Plf0585858ec303030N#%(%#Plfabcbcbcf0585858N#\ %3p%%\ %)%)%(%#Plfcd0d0d0f0585858b#%(%#Plec303030fcd0d0d0b#\ LN\ %3l%)%(%#Plf4808080fcd0d0d0N#\ C\ %-2c%)\ %)',\ 'i':\ '%(%(%#Pl17005f5fe7ffffffb#\ %{Powerline#Functions#GetMode()}\ %)%#Ple7ffffff1f0087afb#%)%(\ %(%#Plc4ff00001f0087afb#%{&readonly\ ?\ \"RO\"\ :\ \"\"}\ %)%(%#Ple7ffffff1f0087afb#%t\ %)%(%#Plc4ff00001f0087afb#%M\ %)%(%#Plc4ff00001f0087afb#%H%W\ %)%#Pl1f0087af18005f87b#%)%<%#Pl00ff000018005f87N#%=%(%#Pl18005f8718005f87N#%(%#Pl7587d7ff18005f87N#\ %{&fileformat}\ %)%)%(%#Pl7587d7ff18005f87N#│%(%#Pl7587d7ff18005f87N#\ %{(&fenc\ ==\ \"\"\ ?\ &enc\ :\ &fenc)}\ %)%)%(%#Pl7587d7ff18005f87N#│%(%#Pl7587d7ff18005f87N#\ %{strlen(&ft)\ ?\ &ft\ :\ \"no\ ft\"}\ %)%)%(%#Pl1f0087af18005f87N#%(%#Pl7587d7ff1f0087afN#\ %3p%%\ %)%)%(%#Pl7587d7ff1f0087afb#%(%#Pl17005f5f7587d7ffb#\ LN\ %3l%)%(%#Pl17005f5f7587d7ffN#\ C\ %-2c%)\ %)',\ 'N':\ '%(\ %(%#Pl58870000eb262626N#%{&readonly\ ?\ \"RO\"\ :\ \"\"}\ %)%(%#Plf58a8a8aeb262626b#%t\ %)%(%#Pl58870000eb262626N#%M\ %)%(%#Pl58870000eb262626N#%H%W\ %)%#Pleb262626e9121212b#%)%<%#Pl00ff0000e9121212N#%=%(%#Pleb262626e9121212N#%(%#Plef4e4e4eeb262626N#\ %3p%%\ %)%)%(%#Plf58a8a8aeb262626b#│%(%#Plf58a8a8aeb262626b#\ LN\ %3l%)%(%#Plf1626262eb262626N#\ C\ %-2c%)\ %)'},0)
setlocal suffixesadd=.java
setlocal swapfile
setlocal synmaxcol=3000
if &syntax != 'java'
setlocal syntax=java
endif
setlocal tabstop=4
setlocal tags=
setlocal textwidth=0
setlocal thesaurus=
setlocal noundofile
setlocal nowinfixheight
setlocal nowinfixwidth
setlocal wrap
setlocal wrapmargin=0
silent! normal! zE
let s:l = 6 - ((5 * winheight(0) + 30) / 61)
if s:l < 1 | let s:l = 1 | endif
exe s:l
normal! zt
6
normal! 0
tabedit src/fr/miblack/chess/piece/Knight.java
set splitbelow splitright
set nosplitbelow
set nosplitright
wincmd t
set winheight=1 winwidth=1
argglobal
nnoremap <buffer> <silent> ,jd :call VjdeGetDocUnderCursor()
nnoremap <buffer> <silent> ,as :call VjdeAppendTemplate("Singleton")
nnoremap <buffer> <silent> ,ii :call VjdeImplementInner()
nnoremap <buffer> <silent> ,oi :call Vjde_override(1)
nnoremap <buffer> <silent> ,oe :call Vjde_override(0)
vnoremap <buffer> <silent> ,en :call Vjde_rft_const()
nnoremap <buffer> <silent> ,ep :call Vjde_rft_arg()
nnoremap <buffer> <silent> ,em :call Vjde_rft_var(1)
nnoremap <buffer> <silent> ,el :call Vjde_rft_var(2)
nnoremap <buffer> <silent> ,ri :call Vjde_remove_imports()
nnoremap <buffer> <silent> ,ai :call Vjde_fix_import1()
nnoremap <buffer> <silent> ,fi :call Vjde_fix_import()
nnoremap <buffer> <silent> ,ft :call Vjde_fix_try()
nnoremap <buffer> <silent> ,fr :call Vjde_fix_throws()
vnoremap <buffer> <silent> ,js :call Vjde_sort_import()
vnoremap <buffer> <silent> ,jt :call Vjde_surround_try()
nnoremap <buffer> <silent> ,jt :call Vjde_surround_try()
nnoremap <buffer> <silent> ,jc :call VjdeGenerateConstructor()
nnoremap <buffer> <silent> ,jg :call Vjde_get_set()
nnoremap <buffer> <silent> ,je :call Vjde_ext_import()
inoreabbr <buffer> logger logger=eclim#java#logging#LoggingInit("logger")
inoreabbr <buffer> log log=eclim#java#logging#LoggingInit("log")
setlocal keymap=
setlocal noarabic
setlocal autoindent
setlocal nobinary
setlocal bufhidden=
setlocal buflisted
setlocal buftype=
setlocal cindent
setlocal cinkeys=0{,0},0),:,0#,!^F,o,O,e
setlocal cinoptions=j1
setlocal cinwords=if,else,while,do,for,switch
setlocal colorcolumn=
setlocal comments=sO:*\ -,mO:*\ \ ,exO:*/,s1:/*,mb:*,ex:*/,://,b:#,:%,:XCOMM,n:>,fb:-
setlocal commentstring=//%s
setlocal complete=.,w,b,u,t,i
setlocal concealcursor=
setlocal conceallevel=0
setlocal completefunc=VjdeCompletionFun0
setlocal nocopyindent
setlocal cryptmethod=
setlocal nocursorbind
setlocal nocursorcolumn
setlocal nocursorline
setlocal define=
setlocal dictionary=
setlocal nodiff
setlocal equalprg=
setlocal errorformat=%E%f:%l:\ %m,%-Z%p^,%-C%.%#,%-G%.%#
setlocal noexpandtab
if &filetype != 'java'
setlocal filetype=java
endif
setlocal foldcolumn=0
setlocal foldenable
setlocal foldexpr=0
setlocal foldignore=#
setlocal foldlevel=0
setlocal foldmarker={{{,}}}
setlocal foldmethod=manual
setlocal foldminlines=1
setlocal foldnestmax=20
setlocal foldtext=foldtext()
setlocal formatexpr=
setlocal formatoptions=croql
setlocal formatlistpat=^\\s*\\d\\+[\\]:.)}\\t\ ]\\s*
setlocal grepprg=
setlocal iminsert=0
setlocal imsearch=0
setlocal include=^s*import
setlocal includeexpr=substitute(v:fname,'\\.','/','g')
setlocal indentexpr=GetJavaIndent()
setlocal indentkeys=0{,0},:,0#,!^F,o,O,e,0=extends,0=implements
setlocal noinfercase
setlocal iskeyword=@,48-57,_,192-255
setlocal keywordprg=
setlocal nolinebreak
setlocal nolisp
setlocal nolist
setlocal makeprg=javac
setlocal matchpairs=(:),{:},[:]
setlocal modeline
setlocal modifiable
setlocal nrformats=octal,hex
set number
setlocal number
setlocal numberwidth=4
setlocal omnifunc=javacomplete#Complete
setlocal path=
setlocal nopreserveindent
setlocal nopreviewwindow
setlocal quoteescape=\\
setlocal noreadonly
setlocal norelativenumber
setlocal norightleft
setlocal rightleftcmd=search
setlocal noscrollbind
setlocal shiftwidth=4
setlocal noshortname
setlocal smartindent
setlocal softtabstop=0
setlocal nospell
setlocal spellcapcheck=[.?!]\\_[\\])'\"\	\ ]\\+
setlocal spellfile=
setlocal spelllang=fr,en
setlocal statusline=%!Pl#Statusline({'r':\ '%(%(%#Ple7ffffffa0d70000b#\ %{Powerline#Functions#GetMode()}\ %)%#Pla0d70000f0585858b#%)%(\ %(%#Plc4ff0000f0585858b#%{&readonly\ ?\ \"RO\"\ :\ \"\"}\ %)%(%#Ple7fffffff0585858b#%t\ %)%(%#Plc4ff0000f0585858b#%M\ %)%(%#Plc4ff0000f0585858b#%H%W\ %)%#Plf0585858ec303030b#%)%<%#Pl00ff0000ec303030N#%=%(%#Plec303030ec303030N#%(%#Plf79e9e9eec303030N#\ %{&fileformat}\ %)%)%(%#Plf79e9e9eec303030N#│%(%#Plf79e9e9eec303030N#\ %{(&fenc\ ==\ \"\"\ ?\ &enc\ :\ &fenc)}\ %)%)%(%#Plf79e9e9eec303030N#│%(%#Plf79e9e9eec303030N#\ %{strlen(&ft)\ ?\ &ft\ :\ \"no\ ft\"}\ %)%)%(%#Plf0585858ec303030N#%(%#Plfabcbcbcf0585858N#\ %3p%%\ %)%)%(%#Plfcd0d0d0f0585858b#%(%#Plec303030fcd0d0d0b#\ LN\ %3l%)%(%#Plf4808080fcd0d0d0N#\ C\ %-2c%)\ %)',\ 'n':\ '%(%(%#Pl16005f0094afd700b#\ %{Powerline#Functions#GetMode()}\ %)%#Pl94afd700f0585858b#%)%(\ %(%#Plc4ff0000f0585858b#%{&readonly\ ?\ \"RO\"\ :\ \"\"}\ %)%(%#Ple7fffffff0585858b#%t\ %)%(%#Plc4ff0000f0585858b#%M\ %)%(%#Plc4ff0000f0585858b#%H%W\ %)%#Plf0585858ec303030b#%)%<%#Pl00ff0000ec303030N#%=%(%#Plec303030ec303030N#%(%#Plf79e9e9eec303030N#\ %{&fileformat}\ %)%)%(%#Plf79e9e9eec303030N#│%(%#Plf79e9e9eec303030N#\ %{(&fenc\ ==\ \"\"\ ?\ &enc\ :\ &fenc)}\ %)%)%(%#Plf79e9e9eec303030N#│%(%#Plf79e9e9eec303030N#\ %{strlen(&ft)\ ?\ &ft\ :\ \"no\ ft\"}\ %)%)%(%#Plf0585858ec303030N#%(%#Plfabcbcbcf0585858N#\ %3p%%\ %)%)%(%#Plfcd0d0d0f0585858b#%(%#Plec303030fcd0d0d0b#\ LN\ %3l%)%(%#Plf4808080fcd0d0d0N#\ C\ %-2c%)\ %)',\ 'v':\ '%(%(%#Pl58870000d0ff8700b#\ %{Powerline#Functions#GetMode()}\ %)%#Pld0ff8700f0585858b#%)%(\ %(%#Plc4ff0000f0585858b#%{&readonly\ ?\ \"RO\"\ :\ \"\"}\ %)%(%#Ple7fffffff0585858b#%t\ %)%(%#Plc4ff0000f0585858b#%M\ %)%(%#Plc4ff0000f0585858b#%H%W\ %)%#Plf0585858ec303030b#%)%<%#Pl00ff0000ec303030N#%=%(%#Plec303030ec303030N#%(%#Plf79e9e9eec303030N#\ %{&fileformat}\ %)%)%(%#Plf79e9e9eec303030N#│%(%#Plf79e9e9eec303030N#\ %{(&fenc\ ==\ \"\"\ ?\ &enc\ :\ &fenc)}\ %)%)%(%#Plf79e9e9eec303030N#│%(%#Plf79e9e9eec303030N#\ %{strlen(&ft)\ ?\ &ft\ :\ \"no\ ft\"}\ %)%)%(%#Plf0585858ec303030N#%(%#Plfabcbcbcf0585858N#\ %3p%%\ %)%)%(%#Plfcd0d0d0f0585858b#%(%#Plec303030fcd0d0d0b#\ LN\ %3l%)%(%#Plf4808080fcd0d0d0N#\ C\ %-2c%)\ %)',\ 'i':\ '%(%(%#Pl17005f5fe7ffffffb#\ %{Powerline#Functions#GetMode()}\ %)%#Ple7ffffff1f0087afb#%)%(\ %(%#Plc4ff00001f0087afb#%{&readonly\ ?\ \"RO\"\ :\ \"\"}\ %)%(%#Ple7ffffff1f0087afb#%t\ %)%(%#Plc4ff00001f0087afb#%M\ %)%(%#Plc4ff00001f0087afb#%H%W\ %)%#Pl1f0087af18005f87b#%)%<%#Pl00ff000018005f87N#%=%(%#Pl18005f8718005f87N#%(%#Pl7587d7ff18005f87N#\ %{&fileformat}\ %)%)%(%#Pl7587d7ff18005f87N#│%(%#Pl7587d7ff18005f87N#\ %{(&fenc\ ==\ \"\"\ ?\ &enc\ :\ &fenc)}\ %)%)%(%#Pl7587d7ff18005f87N#│%(%#Pl7587d7ff18005f87N#\ %{strlen(&ft)\ ?\ &ft\ :\ \"no\ ft\"}\ %)%)%(%#Pl1f0087af18005f87N#%(%#Pl7587d7ff1f0087afN#\ %3p%%\ %)%)%(%#Pl7587d7ff1f0087afb#%(%#Pl17005f5f7587d7ffb#\ LN\ %3l%)%(%#Pl17005f5f7587d7ffN#\ C\ %-2c%)\ %)',\ 'N':\ '%(\ %(%#Pl58870000eb262626N#%{&readonly\ ?\ \"RO\"\ :\ \"\"}\ %)%(%#Plf58a8a8aeb262626b#%t\ %)%(%#Pl58870000eb262626N#%M\ %)%(%#Pl58870000eb262626N#%H%W\ %)%#Pleb262626e9121212b#%)%<%#Pl00ff0000e9121212N#%=%(%#Pleb262626e9121212N#%(%#Plef4e4e4eeb262626N#\ %3p%%\ %)%)%(%#Plf58a8a8aeb262626b#│%(%#Plf58a8a8aeb262626b#\ LN\ %3l%)%(%#Plf1626262eb262626N#\ C\ %-2c%)\ %)'},0)
setlocal suffixesadd=.java
setlocal swapfile
setlocal synmaxcol=3000
if &syntax != 'java'
setlocal syntax=java
endif
setlocal tabstop=4
setlocal tags=
setlocal textwidth=0
setlocal thesaurus=
setlocal noundofile
setlocal nowinfixheight
setlocal nowinfixwidth
setlocal wrap
setlocal wrapmargin=0
silent! normal! zE
let s:l = 9 - ((8 * winheight(0) + 30) / 61)
if s:l < 1 | let s:l = 1 | endif
exe s:l
normal! zt
9
normal! 01l
tabedit src/fr/miblack/chess/piece/King.java
set splitbelow splitright
set nosplitbelow
set nosplitright
wincmd t
set winheight=1 winwidth=1
argglobal
nnoremap <buffer> <silent> ,jd :call VjdeGetDocUnderCursor()
nnoremap <buffer> <silent> ,as :call VjdeAppendTemplate("Singleton")
nnoremap <buffer> <silent> ,ii :call VjdeImplementInner()
nnoremap <buffer> <silent> ,oi :call Vjde_override(1)
nnoremap <buffer> <silent> ,oe :call Vjde_override(0)
vnoremap <buffer> <silent> ,en :call Vjde_rft_const()
nnoremap <buffer> <silent> ,ep :call Vjde_rft_arg()
nnoremap <buffer> <silent> ,em :call Vjde_rft_var(1)
nnoremap <buffer> <silent> ,el :call Vjde_rft_var(2)
nnoremap <buffer> <silent> ,ri :call Vjde_remove_imports()
nnoremap <buffer> <silent> ,ai :call Vjde_fix_import1()
nnoremap <buffer> <silent> ,fi :call Vjde_fix_import()
nnoremap <buffer> <silent> ,ft :call Vjde_fix_try()
nnoremap <buffer> <silent> ,fr :call Vjde_fix_throws()
vnoremap <buffer> <silent> ,js :call Vjde_sort_import()
vnoremap <buffer> <silent> ,jt :call Vjde_surround_try()
nnoremap <buffer> <silent> ,jt :call Vjde_surround_try()
nnoremap <buffer> <silent> ,jc :call VjdeGenerateConstructor()
nnoremap <buffer> <silent> ,jg :call Vjde_get_set()
nnoremap <buffer> <silent> ,je :call Vjde_ext_import()
inoreabbr <buffer> logger logger=eclim#java#logging#LoggingInit("logger")
inoreabbr <buffer> log log=eclim#java#logging#LoggingInit("log")
setlocal keymap=
setlocal noarabic
setlocal autoindent
setlocal nobinary
setlocal bufhidden=
setlocal buflisted
setlocal buftype=
setlocal cindent
setlocal cinkeys=0{,0},0),:,0#,!^F,o,O,e
setlocal cinoptions=j1
setlocal cinwords=if,else,while,do,for,switch
setlocal colorcolumn=
setlocal comments=sO:*\ -,mO:*\ \ ,exO:*/,s1:/*,mb:*,ex:*/,://,b:#,:%,:XCOMM,n:>,fb:-
setlocal commentstring=//%s
setlocal complete=.,w,b,u,t,i
setlocal concealcursor=
setlocal conceallevel=0
setlocal completefunc=VjdeCompletionFun0
setlocal nocopyindent
setlocal cryptmethod=
setlocal nocursorbind
setlocal nocursorcolumn
setlocal nocursorline
setlocal define=
setlocal dictionary=
setlocal nodiff
setlocal equalprg=
setlocal errorformat=%E%f:%l:\ %m,%-Z%p^,%-C%.%#,%-G%.%#
setlocal noexpandtab
if &filetype != 'java'
setlocal filetype=java
endif
setlocal foldcolumn=0
setlocal foldenable
setlocal foldexpr=0
setlocal foldignore=#
setlocal foldlevel=0
setlocal foldmarker={{{,}}}
setlocal foldmethod=manual
setlocal foldminlines=1
setlocal foldnestmax=20
setlocal foldtext=foldtext()
setlocal formatexpr=
setlocal formatoptions=croql
setlocal formatlistpat=^\\s*\\d\\+[\\]:.)}\\t\ ]\\s*
setlocal grepprg=
setlocal iminsert=0
setlocal imsearch=0
setlocal include=^s*import
setlocal includeexpr=substitute(v:fname,'\\.','/','g')
setlocal indentexpr=GetJavaIndent()
setlocal indentkeys=0{,0},:,0#,!^F,o,O,e,0=extends,0=implements
setlocal noinfercase
setlocal iskeyword=@,48-57,_,192-255
setlocal keywordprg=
setlocal nolinebreak
setlocal nolisp
setlocal nolist
setlocal makeprg=javac
setlocal matchpairs=(:),{:},[:]
setlocal modeline
setlocal modifiable
setlocal nrformats=octal,hex
set number
setlocal number
setlocal numberwidth=4
setlocal omnifunc=javacomplete#Complete
setlocal path=
setlocal nopreserveindent
setlocal nopreviewwindow
setlocal quoteescape=\\
setlocal noreadonly
setlocal norelativenumber
setlocal norightleft
setlocal rightleftcmd=search
setlocal noscrollbind
setlocal shiftwidth=4
setlocal noshortname
setlocal smartindent
setlocal softtabstop=0
setlocal nospell
setlocal spellcapcheck=[.?!]\\_[\\])'\"\	\ ]\\+
setlocal spellfile=
setlocal spelllang=fr,en
setlocal statusline=%!Pl#Statusline({'r':\ '%(%(%#Ple7ffffffa0d70000b#\ %{Powerline#Functions#GetMode()}\ %)%#Pla0d70000f0585858b#%)%(\ %(%#Plc4ff0000f0585858b#%{&readonly\ ?\ \"RO\"\ :\ \"\"}\ %)%(%#Ple7fffffff0585858b#%t\ %)%(%#Plc4ff0000f0585858b#%M\ %)%(%#Plc4ff0000f0585858b#%H%W\ %)%#Plf0585858ec303030b#%)%<%#Pl00ff0000ec303030N#%=%(%#Plec303030ec303030N#%(%#Plf79e9e9eec303030N#\ %{&fileformat}\ %)%)%(%#Plf79e9e9eec303030N#│%(%#Plf79e9e9eec303030N#\ %{(&fenc\ ==\ \"\"\ ?\ &enc\ :\ &fenc)}\ %)%)%(%#Plf79e9e9eec303030N#│%(%#Plf79e9e9eec303030N#\ %{strlen(&ft)\ ?\ &ft\ :\ \"no\ ft\"}\ %)%)%(%#Plf0585858ec303030N#%(%#Plfabcbcbcf0585858N#\ %3p%%\ %)%)%(%#Plfcd0d0d0f0585858b#%(%#Plec303030fcd0d0d0b#\ LN\ %3l%)%(%#Plf4808080fcd0d0d0N#\ C\ %-2c%)\ %)',\ 'n':\ '%(%(%#Pl16005f0094afd700b#\ %{Powerline#Functions#GetMode()}\ %)%#Pl94afd700f0585858b#%)%(\ %(%#Plc4ff0000f0585858b#%{&readonly\ ?\ \"RO\"\ :\ \"\"}\ %)%(%#Ple7fffffff0585858b#%t\ %)%(%#Plc4ff0000f0585858b#%M\ %)%(%#Plc4ff0000f0585858b#%H%W\ %)%#Plf0585858ec303030b#%)%<%#Pl00ff0000ec303030N#%=%(%#Plec303030ec303030N#%(%#Plf79e9e9eec303030N#\ %{&fileformat}\ %)%)%(%#Plf79e9e9eec303030N#│%(%#Plf79e9e9eec303030N#\ %{(&fenc\ ==\ \"\"\ ?\ &enc\ :\ &fenc)}\ %)%)%(%#Plf79e9e9eec303030N#│%(%#Plf79e9e9eec303030N#\ %{strlen(&ft)\ ?\ &ft\ :\ \"no\ ft\"}\ %)%)%(%#Plf0585858ec303030N#%(%#Plfabcbcbcf0585858N#\ %3p%%\ %)%)%(%#Plfcd0d0d0f0585858b#%(%#Plec303030fcd0d0d0b#\ LN\ %3l%)%(%#Plf4808080fcd0d0d0N#\ C\ %-2c%)\ %)',\ 'v':\ '%(%(%#Pl58870000d0ff8700b#\ %{Powerline#Functions#GetMode()}\ %)%#Pld0ff8700f0585858b#%)%(\ %(%#Plc4ff0000f0585858b#%{&readonly\ ?\ \"RO\"\ :\ \"\"}\ %)%(%#Ple7fffffff0585858b#%t\ %)%(%#Plc4ff0000f0585858b#%M\ %)%(%#Plc4ff0000f0585858b#%H%W\ %)%#Plf0585858ec303030b#%)%<%#Pl00ff0000ec303030N#%=%(%#Plec303030ec303030N#%(%#Plf79e9e9eec303030N#\ %{&fileformat}\ %)%)%(%#Plf79e9e9eec303030N#│%(%#Plf79e9e9eec303030N#\ %{(&fenc\ ==\ \"\"\ ?\ &enc\ :\ &fenc)}\ %)%)%(%#Plf79e9e9eec303030N#│%(%#Plf79e9e9eec303030N#\ %{strlen(&ft)\ ?\ &ft\ :\ \"no\ ft\"}\ %)%)%(%#Plf0585858ec303030N#%(%#Plfabcbcbcf0585858N#\ %3p%%\ %)%)%(%#Plfcd0d0d0f0585858b#%(%#Plec303030fcd0d0d0b#\ LN\ %3l%)%(%#Plf4808080fcd0d0d0N#\ C\ %-2c%)\ %)',\ 'i':\ '%(%(%#Pl17005f5fe7ffffffb#\ %{Powerline#Functions#GetMode()}\ %)%#Ple7ffffff1f0087afb#%)%(\ %(%#Plc4ff00001f0087afb#%{&readonly\ ?\ \"RO\"\ :\ \"\"}\ %)%(%#Ple7ffffff1f0087afb#%t\ %)%(%#Plc4ff00001f0087afb#%M\ %)%(%#Plc4ff00001f0087afb#%H%W\ %)%#Pl1f0087af18005f87b#%)%<%#Pl00ff000018005f87N#%=%(%#Pl18005f8718005f87N#%(%#Pl7587d7ff18005f87N#\ %{&fileformat}\ %)%)%(%#Pl7587d7ff18005f87N#│%(%#Pl7587d7ff18005f87N#\ %{(&fenc\ ==\ \"\"\ ?\ &enc\ :\ &fenc)}\ %)%)%(%#Pl7587d7ff18005f87N#│%(%#Pl7587d7ff18005f87N#\ %{strlen(&ft)\ ?\ &ft\ :\ \"no\ ft\"}\ %)%)%(%#Pl1f0087af18005f87N#%(%#Pl7587d7ff1f0087afN#\ %3p%%\ %)%)%(%#Pl7587d7ff1f0087afb#%(%#Pl17005f5f7587d7ffb#\ LN\ %3l%)%(%#Pl17005f5f7587d7ffN#\ C\ %-2c%)\ %)',\ 'N':\ '%(\ %(%#Pl58870000eb262626N#%{&readonly\ ?\ \"RO\"\ :\ \"\"}\ %)%(%#Plf58a8a8aeb262626b#%t\ %)%(%#Pl58870000eb262626N#%M\ %)%(%#Pl58870000eb262626N#%H%W\ %)%#Pleb262626e9121212b#%)%<%#Pl00ff0000e9121212N#%=%(%#Pleb262626e9121212N#%(%#Plef4e4e4eeb262626N#\ %3p%%\ %)%)%(%#Plf58a8a8aeb262626b#│%(%#Plf58a8a8aeb262626b#\ LN\ %3l%)%(%#Plf1626262eb262626N#\ C\ %-2c%)\ %)'},0)
setlocal suffixesadd=.java
setlocal swapfile
setlocal synmaxcol=3000
if &syntax != 'java'
setlocal syntax=java
endif
setlocal tabstop=4
setlocal tags=
setlocal textwidth=0
setlocal thesaurus=
setlocal noundofile
setlocal nowinfixheight
setlocal nowinfixwidth
setlocal wrap
setlocal wrapmargin=0
silent! normal! zE
let s:l = 7 - ((6 * winheight(0) + 30) / 61)
if s:l < 1 | let s:l = 1 | endif
exe s:l
normal! zt
7
normal! 0
tabedit src/fr/miblack/chess/piece/Bishop.java
set splitbelow splitright
set nosplitbelow
set nosplitright
wincmd t
set winheight=1 winwidth=1
argglobal
nnoremap <buffer> <silent> ,jd :call VjdeGetDocUnderCursor()
nnoremap <buffer> <silent> ,as :call VjdeAppendTemplate("Singleton")
nnoremap <buffer> <silent> ,ii :call VjdeImplementInner()
nnoremap <buffer> <silent> ,oi :call Vjde_override(1)
nnoremap <buffer> <silent> ,oe :call Vjde_override(0)
vnoremap <buffer> <silent> ,en :call Vjde_rft_const()
nnoremap <buffer> <silent> ,ep :call Vjde_rft_arg()
nnoremap <buffer> <silent> ,em :call Vjde_rft_var(1)
nnoremap <buffer> <silent> ,el :call Vjde_rft_var(2)
nnoremap <buffer> <silent> ,ri :call Vjde_remove_imports()
nnoremap <buffer> <silent> ,ai :call Vjde_fix_import1()
nnoremap <buffer> <silent> ,fi :call Vjde_fix_import()
nnoremap <buffer> <silent> ,ft :call Vjde_fix_try()
nnoremap <buffer> <silent> ,fr :call Vjde_fix_throws()
vnoremap <buffer> <silent> ,js :call Vjde_sort_import()
vnoremap <buffer> <silent> ,jt :call Vjde_surround_try()
nnoremap <buffer> <silent> ,jt :call Vjde_surround_try()
nnoremap <buffer> <silent> ,jc :call VjdeGenerateConstructor()
nnoremap <buffer> <silent> ,jg :call Vjde_get_set()
nnoremap <buffer> <silent> ,je :call Vjde_ext_import()
inoreabbr <buffer> logger logger=eclim#java#logging#LoggingInit("logger")
inoreabbr <buffer> log log=eclim#java#logging#LoggingInit("log")
setlocal keymap=
setlocal noarabic
setlocal autoindent
setlocal nobinary
setlocal bufhidden=
setlocal buflisted
setlocal buftype=
setlocal cindent
setlocal cinkeys=0{,0},0),:,0#,!^F,o,O,e
setlocal cinoptions=j1
setlocal cinwords=if,else,while,do,for,switch
setlocal colorcolumn=
setlocal comments=sO:*\ -,mO:*\ \ ,exO:*/,s1:/*,mb:*,ex:*/,://,b:#,:%,:XCOMM,n:>,fb:-
setlocal commentstring=//%s
setlocal complete=.,w,b,u,t,i
setlocal concealcursor=
setlocal conceallevel=0
setlocal completefunc=VjdeCompletionFun0
setlocal nocopyindent
setlocal cryptmethod=
setlocal nocursorbind
setlocal nocursorcolumn
setlocal nocursorline
setlocal define=
setlocal dictionary=
setlocal nodiff
setlocal equalprg=
setlocal errorformat=%E%f:%l:\ %m,%-Z%p^,%-C%.%#,%-G%.%#
setlocal noexpandtab
if &filetype != 'java'
setlocal filetype=java
endif
setlocal foldcolumn=0
setlocal foldenable
setlocal foldexpr=0
setlocal foldignore=#
setlocal foldlevel=0
setlocal foldmarker={{{,}}}
setlocal foldmethod=manual
setlocal foldminlines=1
setlocal foldnestmax=20
setlocal foldtext=foldtext()
setlocal formatexpr=
setlocal formatoptions=croql
setlocal formatlistpat=^\\s*\\d\\+[\\]:.)}\\t\ ]\\s*
setlocal grepprg=
setlocal iminsert=0
setlocal imsearch=0
setlocal include=^s*import
setlocal includeexpr=substitute(v:fname,'\\.','/','g')
setlocal indentexpr=GetJavaIndent()
setlocal indentkeys=0{,0},:,0#,!^F,o,O,e,0=extends,0=implements
setlocal noinfercase
setlocal iskeyword=@,48-57,_,192-255
setlocal keywordprg=
setlocal nolinebreak
setlocal nolisp
setlocal nolist
setlocal makeprg=javac
setlocal matchpairs=(:),{:},[:]
setlocal modeline
setlocal modifiable
setlocal nrformats=octal,hex
set number
setlocal number
setlocal numberwidth=4
setlocal omnifunc=javacomplete#Complete
setlocal path=
setlocal nopreserveindent
setlocal nopreviewwindow
setlocal quoteescape=\\
setlocal noreadonly
setlocal norelativenumber
setlocal norightleft
setlocal rightleftcmd=search
setlocal noscrollbind
setlocal shiftwidth=4
setlocal noshortname
setlocal smartindent
setlocal softtabstop=0
setlocal nospell
setlocal spellcapcheck=[.?!]\\_[\\])'\"\	\ ]\\+
setlocal spellfile=
setlocal spelllang=fr,en
setlocal statusline=%!Pl#Statusline({'r':\ '%(%(%#Ple7ffffffa0d70000b#\ %{Powerline#Functions#GetMode()}\ %)%#Pla0d70000f0585858b#%)%(\ %(%#Plc4ff0000f0585858b#%{&readonly\ ?\ \"RO\"\ :\ \"\"}\ %)%(%#Ple7fffffff0585858b#%t\ %)%(%#Plc4ff0000f0585858b#%M\ %)%(%#Plc4ff0000f0585858b#%H%W\ %)%#Plf0585858ec303030b#%)%<%#Pl00ff0000ec303030N#%=%(%#Plec303030ec303030N#%(%#Plf79e9e9eec303030N#\ %{&fileformat}\ %)%)%(%#Plf79e9e9eec303030N#│%(%#Plf79e9e9eec303030N#\ %{(&fenc\ ==\ \"\"\ ?\ &enc\ :\ &fenc)}\ %)%)%(%#Plf79e9e9eec303030N#│%(%#Plf79e9e9eec303030N#\ %{strlen(&ft)\ ?\ &ft\ :\ \"no\ ft\"}\ %)%)%(%#Plf0585858ec303030N#%(%#Plfabcbcbcf0585858N#\ %3p%%\ %)%)%(%#Plfcd0d0d0f0585858b#%(%#Plec303030fcd0d0d0b#\ LN\ %3l%)%(%#Plf4808080fcd0d0d0N#\ C\ %-2c%)\ %)',\ 'n':\ '%(%(%#Pl16005f0094afd700b#\ %{Powerline#Functions#GetMode()}\ %)%#Pl94afd700f0585858b#%)%(\ %(%#Plc4ff0000f0585858b#%{&readonly\ ?\ \"RO\"\ :\ \"\"}\ %)%(%#Ple7fffffff0585858b#%t\ %)%(%#Plc4ff0000f0585858b#%M\ %)%(%#Plc4ff0000f0585858b#%H%W\ %)%#Plf0585858ec303030b#%)%<%#Pl00ff0000ec303030N#%=%(%#Plec303030ec303030N#%(%#Plf79e9e9eec303030N#\ %{&fileformat}\ %)%)%(%#Plf79e9e9eec303030N#│%(%#Plf79e9e9eec303030N#\ %{(&fenc\ ==\ \"\"\ ?\ &enc\ :\ &fenc)}\ %)%)%(%#Plf79e9e9eec303030N#│%(%#Plf79e9e9eec303030N#\ %{strlen(&ft)\ ?\ &ft\ :\ \"no\ ft\"}\ %)%)%(%#Plf0585858ec303030N#%(%#Plfabcbcbcf0585858N#\ %3p%%\ %)%)%(%#Plfcd0d0d0f0585858b#%(%#Plec303030fcd0d0d0b#\ LN\ %3l%)%(%#Plf4808080fcd0d0d0N#\ C\ %-2c%)\ %)',\ 'v':\ '%(%(%#Pl58870000d0ff8700b#\ %{Powerline#Functions#GetMode()}\ %)%#Pld0ff8700f0585858b#%)%(\ %(%#Plc4ff0000f0585858b#%{&readonly\ ?\ \"RO\"\ :\ \"\"}\ %)%(%#Ple7fffffff0585858b#%t\ %)%(%#Plc4ff0000f0585858b#%M\ %)%(%#Plc4ff0000f0585858b#%H%W\ %)%#Plf0585858ec303030b#%)%<%#Pl00ff0000ec303030N#%=%(%#Plec303030ec303030N#%(%#Plf79e9e9eec303030N#\ %{&fileformat}\ %)%)%(%#Plf79e9e9eec303030N#│%(%#Plf79e9e9eec303030N#\ %{(&fenc\ ==\ \"\"\ ?\ &enc\ :\ &fenc)}\ %)%)%(%#Plf79e9e9eec303030N#│%(%#Plf79e9e9eec303030N#\ %{strlen(&ft)\ ?\ &ft\ :\ \"no\ ft\"}\ %)%)%(%#Plf0585858ec303030N#%(%#Plfabcbcbcf0585858N#\ %3p%%\ %)%)%(%#Plfcd0d0d0f0585858b#%(%#Plec303030fcd0d0d0b#\ LN\ %3l%)%(%#Plf4808080fcd0d0d0N#\ C\ %-2c%)\ %)',\ 'i':\ '%(%(%#Pl17005f5fe7ffffffb#\ %{Powerline#Functions#GetMode()}\ %)%#Ple7ffffff1f0087afb#%)%(\ %(%#Plc4ff00001f0087afb#%{&readonly\ ?\ \"RO\"\ :\ \"\"}\ %)%(%#Ple7ffffff1f0087afb#%t\ %)%(%#Plc4ff00001f0087afb#%M\ %)%(%#Plc4ff00001f0087afb#%H%W\ %)%#Pl1f0087af18005f87b#%)%<%#Pl00ff000018005f87N#%=%(%#Pl18005f8718005f87N#%(%#Pl7587d7ff18005f87N#\ %{&fileformat}\ %)%)%(%#Pl7587d7ff18005f87N#│%(%#Pl7587d7ff18005f87N#\ %{(&fenc\ ==\ \"\"\ ?\ &enc\ :\ &fenc)}\ %)%)%(%#Pl7587d7ff18005f87N#│%(%#Pl7587d7ff18005f87N#\ %{strlen(&ft)\ ?\ &ft\ :\ \"no\ ft\"}\ %)%)%(%#Pl1f0087af18005f87N#%(%#Pl7587d7ff1f0087afN#\ %3p%%\ %)%)%(%#Pl7587d7ff1f0087afb#%(%#Pl17005f5f7587d7ffb#\ LN\ %3l%)%(%#Pl17005f5f7587d7ffN#\ C\ %-2c%)\ %)',\ 'N':\ '%(\ %(%#Pl58870000eb262626N#%{&readonly\ ?\ \"RO\"\ :\ \"\"}\ %)%(%#Plf58a8a8aeb262626b#%t\ %)%(%#Pl58870000eb262626N#%M\ %)%(%#Pl58870000eb262626N#%H%W\ %)%#Pleb262626e9121212b#%)%<%#Pl00ff0000e9121212N#%=%(%#Pleb262626e9121212N#%(%#Plef4e4e4eeb262626N#\ %3p%%\ %)%)%(%#Plf58a8a8aeb262626b#│%(%#Plf58a8a8aeb262626b#\ LN\ %3l%)%(%#Plf1626262eb262626N#\ C\ %-2c%)\ %)'},1)
setlocal suffixesadd=.java
setlocal swapfile
setlocal synmaxcol=3000
if &syntax != 'java'
setlocal syntax=java
endif
setlocal tabstop=4
setlocal tags=
setlocal textwidth=0
setlocal thesaurus=
setlocal noundofile
setlocal nowinfixheight
setlocal nowinfixwidth
setlocal wrap
setlocal wrapmargin=0
silent! normal! zE
let s:l = 12 - ((11 * winheight(0) + 30) / 61)
if s:l < 1 | let s:l = 1 | endif
exe s:l
normal! zt
12
normal! 0
tabedit src/fr/miblack/chess/color/Color.java
set splitbelow splitright
set nosplitbelow
set nosplitright
wincmd t
set winheight=1 winwidth=1
argglobal
nnoremap <buffer> <silent> ,jd :call VjdeGetDocUnderCursor()
nnoremap <buffer> <silent> ,as :call VjdeAppendTemplate("Singleton")
nnoremap <buffer> <silent> ,ii :call VjdeImplementInner()
nnoremap <buffer> <silent> ,oi :call Vjde_override(1)
nnoremap <buffer> <silent> ,oe :call Vjde_override(0)
vnoremap <buffer> <silent> ,en :call Vjde_rft_const()
nnoremap <buffer> <silent> ,ep :call Vjde_rft_arg()
nnoremap <buffer> <silent> ,em :call Vjde_rft_var(1)
nnoremap <buffer> <silent> ,el :call Vjde_rft_var(2)
nnoremap <buffer> <silent> ,ri :call Vjde_remove_imports()
nnoremap <buffer> <silent> ,ai :call Vjde_fix_import1()
nnoremap <buffer> <silent> ,fi :call Vjde_fix_import()
nnoremap <buffer> <silent> ,ft :call Vjde_fix_try()
nnoremap <buffer> <silent> ,fr :call Vjde_fix_throws()
vnoremap <buffer> <silent> ,js :call Vjde_sort_import()
vnoremap <buffer> <silent> ,jt :call Vjde_surround_try()
nnoremap <buffer> <silent> ,jt :call Vjde_surround_try()
nnoremap <buffer> <silent> ,jc :call VjdeGenerateConstructor()
nnoremap <buffer> <silent> ,jg :call Vjde_get_set()
nnoremap <buffer> <silent> ,je :call Vjde_ext_import()
inoreabbr <buffer> logger logger=eclim#java#logging#LoggingInit("logger")
inoreabbr <buffer> log log=eclim#java#logging#LoggingInit("log")
setlocal keymap=
setlocal noarabic
setlocal autoindent
setlocal nobinary
setlocal bufhidden=
setlocal buflisted
setlocal buftype=
setlocal cindent
setlocal cinkeys=0{,0},0),:,0#,!^F,o,O,e
setlocal cinoptions=j1
setlocal cinwords=if,else,while,do,for,switch
setlocal colorcolumn=
setlocal comments=sO:*\ -,mO:*\ \ ,exO:*/,s1:/*,mb:*,ex:*/,://,b:#,:%,:XCOMM,n:>,fb:-
setlocal commentstring=//%s
setlocal complete=.,w,b,u,t,i
setlocal concealcursor=
setlocal conceallevel=0
setlocal completefunc=VjdeCompletionFun0
setlocal nocopyindent
setlocal cryptmethod=
setlocal nocursorbind
setlocal nocursorcolumn
setlocal nocursorline
setlocal define=
setlocal dictionary=
setlocal nodiff
setlocal equalprg=
setlocal errorformat=%E%f:%l:\ %m,%-Z%p^,%-C%.%#,%-G%.%#
setlocal noexpandtab
if &filetype != 'java'
setlocal filetype=java
endif
setlocal foldcolumn=0
setlocal foldenable
setlocal foldexpr=0
setlocal foldignore=#
setlocal foldlevel=0
setlocal foldmarker={{{,}}}
setlocal foldmethod=manual
setlocal foldminlines=1
setlocal foldnestmax=20
setlocal foldtext=foldtext()
setlocal formatexpr=
setlocal formatoptions=croql
setlocal formatlistpat=^\\s*\\d\\+[\\]:.)}\\t\ ]\\s*
setlocal grepprg=
setlocal iminsert=0
setlocal imsearch=0
setlocal include=^s*import
setlocal includeexpr=substitute(v:fname,'\\.','/','g')
setlocal indentexpr=GetJavaIndent()
setlocal indentkeys=0{,0},:,0#,!^F,o,O,e,0=extends,0=implements
setlocal noinfercase
setlocal iskeyword=@,48-57,_,192-255
setlocal keywordprg=
setlocal nolinebreak
setlocal nolisp
setlocal nolist
setlocal makeprg=javac
setlocal matchpairs=(:),{:},[:]
setlocal modeline
setlocal modifiable
setlocal nrformats=octal,hex
set number
setlocal number
setlocal numberwidth=4
setlocal omnifunc=javacomplete#Complete
setlocal path=
setlocal nopreserveindent
setlocal nopreviewwindow
setlocal quoteescape=\\
setlocal noreadonly
setlocal norelativenumber
setlocal norightleft
setlocal rightleftcmd=search
setlocal noscrollbind
setlocal shiftwidth=4
setlocal noshortname
setlocal smartindent
setlocal softtabstop=0
setlocal nospell
setlocal spellcapcheck=[.?!]\\_[\\])'\"\	\ ]\\+
setlocal spellfile=
setlocal spelllang=fr,en
setlocal statusline=%!Pl#Statusline({'r':\ '%(%(%#Ple7ffffffa0d70000b#\ %{Powerline#Functions#GetMode()}\ %)%#Pla0d70000f0585858b#%)%(\ %(%#Plc4ff0000f0585858b#%{&readonly\ ?\ \"RO\"\ :\ \"\"}\ %)%(%#Ple7fffffff0585858b#%t\ %)%(%#Plc4ff0000f0585858b#%M\ %)%(%#Plc4ff0000f0585858b#%H%W\ %)%#Plf0585858ec303030b#%)%<%#Pl00ff0000ec303030N#%=%(%#Plec303030ec303030N#%(%#Plf79e9e9eec303030N#\ %{&fileformat}\ %)%)%(%#Plf79e9e9eec303030N#│%(%#Plf79e9e9eec303030N#\ %{(&fenc\ ==\ \"\"\ ?\ &enc\ :\ &fenc)}\ %)%)%(%#Plf79e9e9eec303030N#│%(%#Plf79e9e9eec303030N#\ %{strlen(&ft)\ ?\ &ft\ :\ \"no\ ft\"}\ %)%)%(%#Plf0585858ec303030N#%(%#Plfabcbcbcf0585858N#\ %3p%%\ %)%)%(%#Plfcd0d0d0f0585858b#%(%#Plec303030fcd0d0d0b#\ LN\ %3l%)%(%#Plf4808080fcd0d0d0N#\ C\ %-2c%)\ %)',\ 'n':\ '%(%(%#Pl16005f0094afd700b#\ %{Powerline#Functions#GetMode()}\ %)%#Pl94afd700f0585858b#%)%(\ %(%#Plc4ff0000f0585858b#%{&readonly\ ?\ \"RO\"\ :\ \"\"}\ %)%(%#Ple7fffffff0585858b#%t\ %)%(%#Plc4ff0000f0585858b#%M\ %)%(%#Plc4ff0000f0585858b#%H%W\ %)%#Plf0585858ec303030b#%)%<%#Pl00ff0000ec303030N#%=%(%#Plec303030ec303030N#%(%#Plf79e9e9eec303030N#\ %{&fileformat}\ %)%)%(%#Plf79e9e9eec303030N#│%(%#Plf79e9e9eec303030N#\ %{(&fenc\ ==\ \"\"\ ?\ &enc\ :\ &fenc)}\ %)%)%(%#Plf79e9e9eec303030N#│%(%#Plf79e9e9eec303030N#\ %{strlen(&ft)\ ?\ &ft\ :\ \"no\ ft\"}\ %)%)%(%#Plf0585858ec303030N#%(%#Plfabcbcbcf0585858N#\ %3p%%\ %)%)%(%#Plfcd0d0d0f0585858b#%(%#Plec303030fcd0d0d0b#\ LN\ %3l%)%(%#Plf4808080fcd0d0d0N#\ C\ %-2c%)\ %)',\ 'v':\ '%(%(%#Pl58870000d0ff8700b#\ %{Powerline#Functions#GetMode()}\ %)%#Pld0ff8700f0585858b#%)%(\ %(%#Plc4ff0000f0585858b#%{&readonly\ ?\ \"RO\"\ :\ \"\"}\ %)%(%#Ple7fffffff0585858b#%t\ %)%(%#Plc4ff0000f0585858b#%M\ %)%(%#Plc4ff0000f0585858b#%H%W\ %)%#Plf0585858ec303030b#%)%<%#Pl00ff0000ec303030N#%=%(%#Plec303030ec303030N#%(%#Plf79e9e9eec303030N#\ %{&fileformat}\ %)%)%(%#Plf79e9e9eec303030N#│%(%#Plf79e9e9eec303030N#\ %{(&fenc\ ==\ \"\"\ ?\ &enc\ :\ &fenc)}\ %)%)%(%#Plf79e9e9eec303030N#│%(%#Plf79e9e9eec303030N#\ %{strlen(&ft)\ ?\ &ft\ :\ \"no\ ft\"}\ %)%)%(%#Plf0585858ec303030N#%(%#Plfabcbcbcf0585858N#\ %3p%%\ %)%)%(%#Plfcd0d0d0f0585858b#%(%#Plec303030fcd0d0d0b#\ LN\ %3l%)%(%#Plf4808080fcd0d0d0N#\ C\ %-2c%)\ %)',\ 'i':\ '%(%(%#Pl17005f5fe7ffffffb#\ %{Powerline#Functions#GetMode()}\ %)%#Ple7ffffff1f0087afb#%)%(\ %(%#Plc4ff00001f0087afb#%{&readonly\ ?\ \"RO\"\ :\ \"\"}\ %)%(%#Ple7ffffff1f0087afb#%t\ %)%(%#Plc4ff00001f0087afb#%M\ %)%(%#Plc4ff00001f0087afb#%H%W\ %)%#Pl1f0087af18005f87b#%)%<%#Pl00ff000018005f87N#%=%(%#Pl18005f8718005f87N#%(%#Pl7587d7ff18005f87N#\ %{&fileformat}\ %)%)%(%#Pl7587d7ff18005f87N#│%(%#Pl7587d7ff18005f87N#\ %{(&fenc\ ==\ \"\"\ ?\ &enc\ :\ &fenc)}\ %)%)%(%#Pl7587d7ff18005f87N#│%(%#Pl7587d7ff18005f87N#\ %{strlen(&ft)\ ?\ &ft\ :\ \"no\ ft\"}\ %)%)%(%#Pl1f0087af18005f87N#%(%#Pl7587d7ff1f0087afN#\ %3p%%\ %)%)%(%#Pl7587d7ff1f0087afb#%(%#Pl17005f5f7587d7ffb#\ LN\ %3l%)%(%#Pl17005f5f7587d7ffN#\ C\ %-2c%)\ %)',\ 'N':\ '%(\ %(%#Pl58870000eb262626N#%{&readonly\ ?\ \"RO\"\ :\ \"\"}\ %)%(%#Plf58a8a8aeb262626b#%t\ %)%(%#Pl58870000eb262626N#%M\ %)%(%#Pl58870000eb262626N#%H%W\ %)%#Pleb262626e9121212b#%)%<%#Pl00ff0000e9121212N#%=%(%#Pleb262626e9121212N#%(%#Plef4e4e4eeb262626N#\ %3p%%\ %)%)%(%#Plf58a8a8aeb262626b#│%(%#Plf58a8a8aeb262626b#\ LN\ %3l%)%(%#Plf1626262eb262626N#\ C\ %-2c%)\ %)'},0)
setlocal suffixesadd=.java
setlocal swapfile
setlocal synmaxcol=3000
if &syntax != 'java'
setlocal syntax=java
endif
setlocal tabstop=4
setlocal tags=
setlocal textwidth=0
setlocal thesaurus=
setlocal noundofile
setlocal nowinfixheight
setlocal nowinfixwidth
setlocal wrap
setlocal wrapmargin=0
silent! normal! zE
let s:l = 7 - ((6 * winheight(0) + 30) / 61)
if s:l < 1 | let s:l = 1 | endif
exe s:l
normal! zt
7
normal! 0
tabnext 14
if exists('s:wipebuf')
  silent exe 'bwipe ' . s:wipebuf
endif
unlet! s:wipebuf
set winheight=1 winwidth=20 shortmess=filnxtToO
let s:sx = expand("<sfile>:p:r")."x.vim"
if file_readable(s:sx)
  exe "source " . fnameescape(s:sx)
endif
let &so = s:so_save | let &siso = s:siso_save
doautoall SessionLoadPost
unlet SessionLoad
" vim: set ft=vim :
