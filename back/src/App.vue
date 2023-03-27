<template>
    <!-- <nav>
    <router-link to="/">Home</router-link> |
    <router-link to="/about">About</router-link>
    </nav> -->
    <router-view />
</template>

<style>
    #app {
        font-family: Avenir, Helvetica, Arial, sans-serif;
        -webkit-font-smoothing: antialiased;
        -moz-osx-font-smoothing: grayscale;
        text-align: center;
        color: #2c3e50;
    }

    body {
        margin: 0;
        padding: 0;
    }

    body::-webkit-scrollbar {
        display: none;
    }

    input {
        text-indent: 5px;
        color: white;
        border: 2px #2746aa solid;
        height: 20px;
        width: 80px;
        background: linear-gradient(0deg, #2746aa, rgba(0, 0, 0, 0) 25%, rgba(0, 0, 0, 0) 75%, #2746ab);
    }
    input:focus {
        outline: none;
    }
    input::placeholder {
        color: #f1f1f1;
    }
    
</style>
