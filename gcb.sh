str=$1
git checkout -b $(git config --global user.name)-$(date "+%Y-%m%d")-$str
