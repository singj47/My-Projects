%include "simple_io.inc"
   
global  asm_main

SECTION .data
        s1 db "+++ ",0
        s2 db "... ",0
        s3 db "    ",0
        maxArray: db 20,20,20,20,20,20,20,20,20,20,20
        Max: dq 0
        BiggestMax: dq 0
        err1: db "incorrect number of command line arguments",0
        err2: db "input string too long",0
        str1: db "input string: ",0
        str2: db "border array: ",0

SECTION .text
;; subroutine maxbord
;; expects 2 parameters on stack, hence 2 params+1 fake
        maxbord:
            enter     0,0             ; setup routine
        saveregs                         ; save all registers

        mov qword[Max],0
        mov     rax, [rbp+24]           ; getting input string through stack - first real parameter
        mov r13,rax                 
        mov rax,0
        mov     rax, [rbp+32]           ; getting length of input string through stack - second real parameter
        mov r12,rax                 
        cmp r12, 1
        je LOOPOUTDONE
        mov rcx,1 

        ;;; Loop for length of string
        LOOPMAXOUT: 
            mov rbx, 0            
            mov dl,1
            mov rax,0
            mov al,dl
            mov rax,0
                    LOOPMAXIN:            ; finds the border 
                        mov rax,0
                        mov rax,qword[r13+rbx]
                        mov rax,0
                        mov rax,r12
                        sub rax,rcx
                        add rax,rbx
                        mov r11,rax
                        mov rax,0
                        mov al,byte[r13+r11]
                        cmp byte[r13+rbx],al
            je CONTINUE
            jmp LOOPMAXIN_EXIT

        CONTINUE:
            inc rbx
            cmp rbx,rcx
            je  LOOPMAXINDONE
            jmp LOOPMAXIN

        LOOPMAXINDONE:
            jmp ISBORDER

        LOOPMAXIN_EXIT:
            mov dl,0

        ISBORDER:
            mov rax,0
            mov al,dl
            cmp dl,1
            je ASSIGNMAX
            jmp ENDISBORDER

        ASSIGNMAX:
            cmp qword [Max],rcx
            jl RBXMAX
            jmp ENDISBORDER

        RBXMAX:
            mov qword[Max],rcx

        ENDISBORDER:
            inc rcx
            cmp rcx,r12
            je LOOPOUTDONE
            jmp LOOPMAXOUT

        LOOPOUTDONE:
            mov rax,qword[Max]

    restoregs                            ; restore all registers   
    leave                     
    ret

;; subroutine simple_display
;; expects 2 parameters on stack, hence 2 params+1 fake
;; this subroutine displays border array
        simple_display:
            enter     0,0             ; setup routine
        saveregs                         ; save all registers
        mov rbx,0
        mov rbx,  [rbp+24]              ; getting input array through stack - first real parameter
        mov al,byte [rbx]
        mov rax,0
        mov rax, [rbp+32]               ; getting length of array through stack - second real parameter
        mov rcx,0
        mov rcx,rbx
        mov r8b,0

        LL1:
            mov al,0
            mov al,byte[rcx]
            cmp al,20
            je ENDLL1
            mov dl,al
            cmp r8b,0
            je NOCOMA
            mov al,','
            call print_char
            NOCOMA:
                mov al,dl
                call print_int
                add rcx,1
                add r8b,1
                cmp al,20
                jb LL1

        ENDLL1:
        
        restoregs                       ; restore all registers   
        leave                     
        ret

;; subroutine fancy_display
;; expects 2 parameters on stack, hence 2 params+1 fake
;; this subroutine is used to display the histogram
        fancy_display:
            enter     0,0             ; setup routine
        saveregs                         ; save all registers
        mov rbx,0
        mov rbx,  [rbp+24]              ; getting array through stack - first real parameter
        mov al,byte [rbx]
        mov rax,0
        mov     rax, [rbp+32]           ; getting length of array through stack - second real parameter
        mov al,0
        mov r12b,byte [BiggestMax]   

        loopouter:
            mov rcx,rbx
                loop2:
                    cmp r12b,1
                    jle loopouterdec
                    mov rax,0
                    mov al,byte [rcx]
                    add rcx,1
                    cmp al,20
                    je loopouterdec
                    cmp r12b,al
                    ja plus
                    mov rax, s1
                    call print_string
                    jmp loop2
                plus:
                    mov rax, s3
                    call print_string
                    jmp loop2

        loopouterdec:
            call print_nl
            sub r12b,1
            cmp r12b,2
            jl mainend
            jmp loopouter

        mainend:
            mov rcx,maxArray
            loop3:
                mov rax,0
                mov al,byte [rcx]
                add rcx,1
                cmp al, 20
                je mainFinalEnd
                cmp al,0
                je dots1
                cmp al, 0
                jne plus1

        plus1:
            mov rax, s1
            call print_string
            jmp loop3

        dots1:
            mov rax, s2
            call print_string
            jmp loop3

        mainFinalEnd:

        restoregs                       ; restore all registers   
        leave                     
        ret
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; checks for incorrect number of arguments.
;; checks if the length of the string is greater than 12 or not.
;; calls maxbord , simple_display and fancy_display.

        asm_main:
            enter     0,0             ; setup routine
        saveregs                         ; save all registers
        mov rax,rdi
        cmp rax,2
        jne INCORRECT_ARG
        mov rax,0
     mov rbx, qword [rsi+8]

        mov rax,qword [rsi+8]


        mov r10,qword [rsi+8]
        mov r11,qword [rsi+16]
        mov r12,rax
        mov rax,0
        mov rcx,0
        mov rbx,[rsi+8]

        LOOP1:
            mov al,byte [rbx+rcx]
            inc rcx
            cmp al,0
            jne LOOP1
            mov rax,0
            dec rcx
            mov rax,rcx
            mov r11,0
            mov r11,rcx
            mov rbx,rcx
            sub r11,0
            cmp rcx,12
            jg LENGTH_ERROR
            mov rax,str1
            call print_string
            mov rax,qword [rsi+8]
            call print_string
            call print_nl
            
;; calling maxbord repitively with two arguments string and string length
        mov rax,str2
        call print_string
        mov rbx,0
        add rbx,maxArray
        mov r8,rcx                  ; computes the length of MaxArray

        L1:
            push rcx                ; passing length of input string to stack
            push r12                ; passing input string
            sub     rsp, 8              ; fake parameter
            call maxbord            
            add rsp,24              ; sending stack to its initial state
            dec rcx
            mov [rbx],rax
            add r12,1
            add rbx,1
            cmp rcx,0
            jne L1
            mov [rbx],byte 20       ; storing 20 at last to show end
            mov rcx,maxArray
            mov rax,0       
            mov r12b,0
            LOOPMAXA:
                mov al,0     
                mov al, byte[rcx]
                cmp al,20
                je ENDMAXA
                inc rcx
                cmp r12b,al
                jle MAXA
                cmp al,20
                jne LOOPMAXA       

         MAXA:
              mov r12b,al
              jmp LOOPMAXA

         ENDMAXA:
              mov byte[BiggestMax],r12b
            push r8                 ; passing length of border array to stack
            push maxArray           ; passing array
            sub     rsp, 8              ; fake parameter
            call simple_display
            add rsp,24              ; sending stack to its initial state 
            call print_nl
            call print_nl
            call print_nl
            call print_nl
            push r8                 ; passing length of border array to stack
            push maxArray           ; passing array
            sub     rsp, 8              ; fake parameter
            call fancy_display
            add rsp,24              ; sending stack to its initial state 
            call print_nl
            call print_nl
            jmp END_ALL

        INCORRECT_ARG:
            mov rax,err1
            call print_string
            call print_nl
            jmp END_ALL

        LENGTH_ERROR:
            mov rax,err2
            call print_string
            call print_nl

        END_ALL:
            restoregs               ; restore all registers 
        leave                     
        ret