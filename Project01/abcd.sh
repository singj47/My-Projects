#!/bin/bash

read -p "please enter a (file with extention) " f
characters=0
spaces=0
words=0
lines=0
if [ -f "$f" ] ; then
        while IFS= read -r line
        do
                lines=$((lines + 1))
        done < "$f"

        characters=$(wc -c < "$f")
        words=$(wc -w < "$f")
        spaces=$(tr -cd '[:space:]' < "$f" | wc -m)
        characters=$((characters - spaces))
fi
echo "No. of Words: "$words""
echo "No. of Characters: "$characters""
echo "No. of White Spaces: "$spaces""
echo "No. of Lines: "$lines""
