# Set the namespace and pods to monitor
namespace=prod
pods=(xihang-partner-training-service-teacher-prod-java-app-78f442c5x
  xihang-partner-training-service-teacher-prod-java-app-78f4hpgrj)

# Set the tail and follow options
tail=200
follow=true

fun() {
  # Print the pod name
  echo "Monitoring pod $1..."

  # Run the kubectl logs command in the background
  #  kubectl logs -n=$namespace --tail=$tail -f $pod --all-containers --prefix=$

  sleep 1 &
  echo "Sleeping... 1 " $1
  wait

  sleep 3 &
  echo "Sleeping... 3 " $1
  wait

  # 如果pod的名称中包含了 f442c5x 直接 exit
  if [[ $1 == *"f442c5x"* ]]; then
    echo "exit"
    exit 0
  fi

  sleep 5 &
  echo "Sleeping... 5 " $1
  wait

  sleep 2 &
  echo "Sleeping... 2 " $1
  wait
}

# Set the prefix option
prefix=pod-name

# Loop through the pods
for pod in "${pods[@]}"; do
  fun $pod &
done

# Wait for the background jobs to finish
wait
