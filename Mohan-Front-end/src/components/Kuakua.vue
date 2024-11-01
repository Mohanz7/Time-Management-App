<template>
    <div>
      <!-- Your component content goes here -->
    </div>
  </template>
  
  <script>
  export default {
    mounted() {
        const script1 = document.createElement('script');
    script1.innerHTML = `
      window.difyChatbotConfig = { 
        token: 'iYOtZZhtbZ2qTTVx'
      };
    `;
    
    const script2 = document.createElement('script');
    script2.src = 'https://udify.app/embed.min.js';
    script2.id = 'iYOtZZhtbZ2qTTVx';
    script2.defer = true;

    // Append the script elements to the head of the document
    document.head.appendChild(script1);
    document.head.appendChild(script2);
  },

  };
  </script>
  
  <style>
  /* Your component styles go here */
  </style>