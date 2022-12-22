#!/bin/sh

# 获取用户名
USERNAME=$(git config --global user.name)

# 日期
DATE=$(date "+%m%d")

# 功能
echo "Select the type of the new branch:"
echo "1) Feature branch (功能分支)"
echo "2) Bugfix branch (修复分支)"
echo "3) Performance improvement branch (性能优化分支)"
echo "4) Refactoring branch (重构分支)"
echo "5) Documentation branch (文档分支)"
echo "6) Other branch (其他分支)"
read -p "Enter your choice (1-6): " CHOICE

# Set the type of the branch based on the user's choice
case $CHOICE in
  1) TYPE="feature/";;
  2) TYPE="bugfix/";;
  3) TYPE="performance/";;
  4) TYPE="refactoring/";;
  5) TYPE="docs/";;
  6) TYPE="other/";;
  *) echo "Invalid choice."; exit 1;;
esac

# Construct the branch name
BRANCH_NAME="$USERNAME-$DATE-$TYPE"

# Read the branch description from the user
while true; do
  read -p "Enter a description for the new branch: " DESCRIPTION
  if [ -n "$DESCRIPTION" ]; then
    break
  fi
  echo "Description cannot be empty."
done

# Append the description to the branch name
BRANCH_NAME="$BRANCH_NAME$DESCRIPTION"

# Create the new branch and switch to it
git checkout -b "$BRANCH_NAME"
