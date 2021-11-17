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
if [ "$VAR" = "findtag" ] ; then
    comment=#
    read -p "Enter a Tag: " T
    if [ -f "$T".log ] ; then
        rm "$T".log
        echo "$T" > "$T".log
    fi
    if [ ! -f "T".log ] ; then
        echo "$T" > "$T".log
    fi
    for File in ./**
        do
            if [[ "$File" == *.py ]] ; then
                while IFS= read -r l
                    do
                        if [[ "$l" == "$comment"* ]] ; then
                             l="${l} "$T""
                             echo "$l" >> "$T".log
                        fi
                done < "$File"
            fi
    done
fi
if [ "$VAR" = "checkoutlatestmerge" ] ; then
	git checkout :/Merge
fi
if [ "$VAR" = "backuprestore" ] ; then
	read -p "Enter Choice: " Option
        if [ "$Option" = "backup" ] ; then
                if [ -d backup ] ; then
                        rm -r backup
                fi
                if [ ! -d backup ] ; then
                        mkdir backup
                fi
                for File in *.tmp
                do
                        echo $(readlink -f "$File") >> /home/singj47/private/CS1XA3/Project01/backup/restore.log
                        mv "$File" backup
                done
        fi
        if [ "$Option" = "restore" ] ; then
                cd backup
		if [ ! -f "restore.log" ] ; then
			echo " FILE DOES NOT EXIST"
		fi
		if [ -f "restore.log" ] ; then
                	for File  in ./**
                	do
                		if [[ "$File" == *.tmp ]] ; then
                        		a=$(basename "$File")
                        		filename=restore.log
                        		while IFS= read -r l
                       			do
                                		a1=$(basename "$l")
                                		if [[ "$a1" == "$a" ]] ; then
                                        		mv "$File" "$l"
                                		fi
                        		done < "$filename"
                		fi
                	done
      		fi
	fi
fi
if [ "$VAR" = "changelinespace" ] ; then
	read -p "Enter a file name: " VAR2
	if [ -f "new.txt" ] ; then
        	rm new.txt
        	touch new.txt
	fi
	if [ ! -f "new.txt" ] ; then
		touch new.txt
	fi
	if [ -f "$VAR2" ] ; then
        	while IFS= read -r l
            	do
                	echo "$l" >> "new.txt"
                	echo "" >> "new.txt"
        	done < "$VAR2"
		cp "new.txt" "$VAR2"
        fi
	if [ ! -f "$VAR2" ] ; then 
		echo "NO SUCH FILE EXISTS"
	fi
fi

if [ "$VAR" = "stuffcount" ] ; then
	read -p "please enter a (file with extention) " File
	characters=0
	spaces=0
	words=0
	lines=0
	if [ ! -f "$File" ] ; then
		echo "NO SUCH FILE EXISTS"
	fi
	if [ -f "$File" ] ; then
        	while IFS= read -r l
        	do
                	lines=$((lines + 1))
       		done < "$File"

        	characters=$(wc -c < "$File")
        	words=$(wc -w < "$File")
        	spaces=$(tr -cd '[:space:]' < "$File" | wc -m)
        	characters=$((characters - spaces))

		echo "No. of Words: "$words""
		echo "No. of Characters: "$characters""
		echo "No. of White Spaces: "$spaces""
		echo "No. of Lines: "$lines""
	fi
fi
