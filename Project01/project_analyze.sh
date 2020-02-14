#!/bin/bash
## Script Input

VAR=${1}
if [ -f fixmelog.txt ] ; then
	echo "" > fixmelog.txt
fi
if [ "$VAR" = "fixmelog" ] ; then
    String="FIXME"
    for File  in ./**
        do
            if [ -f "$File" ] ; then
                Last=$(tail -n 1   "$File")
                if [[ "$Last" == *"$String"* ]] ; then
                    echo "$File" >> fixmelog.txt
                fi
            fi
    done
fi

if [ "$VAR" = "filetypecount" ] ; then
    read -p "Please Enter The Extension:  " VAR1
    count=0
    for f in ./**
            do
                if [ -f "$f" ] ; then
                        if [[ $f == *."$VAR1" ]] ; then
                                count=$((count + 1))
                        fi
                fi
    done
    echo "$count"


fi

if [ "$VAR" = "filesizelist" ] ; then
    ls -lsh |sort -rh|sed 's/^[0-9]* //'
fi
