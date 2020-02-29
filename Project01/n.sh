#!/bin/bash

line=hey hi how hey
echo $(wc -w <<< "$line")
