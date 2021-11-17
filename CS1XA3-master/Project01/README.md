#  CS 1XA3 Project01 - <singj47>
## Usage
   Execute this script from project root with:
        chmod +x CS1XA3/Project01/project_analyze.sh
        ./CS1XA3/Project01/project_analyze arg1 arg2 ...
   With possible arguments
arg1: execute the commands that are being passed
## Feature 01 - Script Input
Description : It takes the following arguments and runs the mentioned feature:
        1.fixmelog
        2.filetypecount
        3.filesizelist
Execution : Type the feature you want to execute.
Reference : some code was take from [https://mac1xa3.ca/Slides/Week04/1XA3_Lab_Week04.html]
## Feature 02- fixmelog
Description : this feature Finds every file in my repo that has the word FIXME in the last line and put the list of these file names in CS1XA3/Project01/fixme.log with each file separated by a
newline then creates the file CS1XA3/Project01/fixme.log if it doesn’t exist,and  overwrite it if it does
Execution : execute this feature by typing fixmelog after it tells you to put in the feature you need to execute.
Reference : some code was taken from [https://stackoverflow.com/questions/39615142/bash-get-last-line-from-a-variable]
## Feature 03 - file type count
Description : Uses the read command (with a prompt) after plugging in the extension(.txt,.pdf,.sh,.py, etc) you want, it to calculate it outputs the number of files in the repo.
Execution : type in the extension you want it to calculate the files for
Reference : some code was taken from [ https://askubuntu.com/questions/454564/count-total-number-of-files-in-particular-directory-with-specific-extension]
## Feature 04 - file size list
Description : It lists all files in the repo  and their sizes in a human readable format (i.e KB, MB, GB, etc) ans list the files sorted from largest to smallest.
Execution : pass the argument filesizelist and it will display the size and name of the file from largest to smallest.
Reference :some code was taken from [ https://superuser.com/questions/368784/how-can-i-sort-all-files-by-size-in-a-directory]
## Feature 05 - find tag
Description : Uses the read command (with a prompt)to input tag , name of the file with the extension .log is created along with the tag name given , lines in the file starting with # are taken and 
put in the file tag.log.
Execution : execute this feature by giving an input findtag then the user is prompt to give a tag then a file tag.log is created and the tag is written then the feature searches every file with the
extension .py and in it the lines starting with # is moved to tag.log along with the tag. 
Reference:some code was taken from [https://linuxize.com/post/bash-concatenate-strings/]
## Feature 06 - checkout latest merge 
Description :Finds the latest commit with the word merge and checkout commit.                                      
Execution :execute this feature by giving an input checkoutlatestmerge , the feature finds the latest commit with the word merge. 
Reference:some code was taken from [https://stackoverflow.com/questions/4898837/how-to-find-last-merge-in-git]
## Feature 07 - Backup and Restore(10 points)
Description: Using the read command, prompt the user to Backup or Restore, if the user chooses backup all files with the extension .tmp are searched in the current repo and then are copied
in a directory backup and file from the original location is removed and a file restore.log is created where there is list of paths of orignal locations.If the user chooses restore the file
restore.log is used to restore the path of original locations and if no such file exists it shows an error message.
Execution :execute this feature by giving an input backupandrestore then choose backup or restore, if the user selects backup an empty directory is created if it doesnt exists and empty the directory
if it does, then find all files that end in the .tmp extension,
∗ copy them to the CS1XA3/Project01/backup directory
∗ delete them from their original location
∗ create a file CS1XA3/Project01/backup/restore.log that contains a list of paths of the
files original locations
If the user selects Restore:
– use the file CS1XA3/Project01/backup/restore.log to restore the files to their original lo- cation
– if the file does not exist, through an error message
Reference:some code was taken from [https://stackoverflow.com/questions/965053/extract-filename-and-extension-in-bash]
## Custom Feature SomeFeature
## Custom Feature 01 -stuffcount
Description : This feature prompts the user to input a file name . If the file doesnt exist it gives an error message , if it does then the feature count number of words,
characters, white spaces and no. of lines  in a given file .
Execution :execute this feature by giving an input stuffcount after which the user is to type in a file name. If the file exists the feature counts the number of words , characters , spaces and number
of lines in the file , if not it throws an error message. 
Reference :some code was taken from [https://unix.stackexchange.com/questions/212859/how-can-i-count-the-number-of-whitespace-characters-in-a-file]
## Custom Feature 02 -changelinespace 
Description : This feature prompts the user to input a file name . If the file doesnt exist it gives an error message , if it does then the feature reads the file and add extra an spacing to it.
Execution :execute this feature by giving an input changelinespace then enter a file name , if the file exists then add an extra spacing to each line in the file if it doesnt exist then displays
an error message.
Reference :some code was taken from [ nowhere]
