/**
 * 
 */
       function myFunction() {
  return "Write something clever here...";
}



      // Set the target time in milliseconds (30 minutes = 1800000 ms)
const targetTime = Date.now() + 2700000;

// Set the duration of the interval in milliseconds (1 second = 1000 ms)
const intervalDuration = 1000;

// Get the timer element
const timerElement = document.getElementById('timer');

// Start the interval
const intervalId = setInterval(() => {
  // Get the remaining time in milliseconds
  const remainingTime = targetTime - Date.now();

  // Check if the countdown is finished
  if (remainingTime <= 0) {
    // Clear the interval
    clearInterval(intervalId);

    // Execute the function that sends the HTTP post request
    sendPostRequest();
  } else {
    // Convert the remaining time to minutes and seconds
    const minutes = Math.floor(remainingTime / 60000);
    const seconds = Math.floor((remainingTime % 60000) / 1000);

    // Update the timer element
    timerElement.innerText = `${minutes}:${seconds.toString().padStart(2, '0')}`;
  }
}, intervalDuration);

// Function that sends the HTTP post request
function sendPostRequest() {
  // Your code to send HTTP post request goes here
  console.log('Countdown finished');
}




