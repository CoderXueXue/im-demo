#!/bin/bash

# Prompt the user to enter search terms
echo "Enter search terms: "
read search_terms

# Search for directories that contain all of the search terms in their name
directories=`find .. -type d -name "*$search_terms*"`

# If no directories were found, display a message and exit
if [ -z "$directories" ]; then
  echo "No directories found"
  exit
fi

# Filter the list of directories to only include those whose parent directory
# name contains the search terms
filtered_directories=""
for directory in $directories; do
  parent_directory=`dirname "$directory"`
  if [[ "$parent_directory" == *"$search_terms"* ]]; then
    filtered_directories="$filtered_directories $directory"
  fi
done

# If no directories were found, display a message and exit
if [ -z "$filtered_directories" ]; then
  echo "No directories found"
  exit
fi

# Print the list of directories and prompt the user to select one
echo "Select a directory:"
select directory in $filtered_directories; do
  if [ -n "$directory" ]; then
    # Change to the selected directory
    cd "$directory"
    break
  fi
done

# Print the current directory to confirm the change
pwd
