pipeline {
agent any 
/*MAKE SURE TO CHECK WHICH BRANCH BEFORE EDITING*/
stages {
    
    stage ('Hello World') {
      steps {
        echo "Hello World"
        
      }
    }
    
    stage ('Compile') {
      steps {
        /*Put whatever steps need to be automated for a compile here IE running a bat file or running npm (npm requires node)*/
        
        /*bat 'Build bat'*/
        /*sh 'npm install'*/
        echo "Compiled Success!"
      }
    }
  
      stage ('JUnit') {
      steps {
      /*This is where you'd command the JUnit tests to run, if there are any.*/
        echo "Testing Passed!"
      }
    }
  
      stage ('Quality-Gate') {
      steps {
        /* more or less quality gate is just a series of criteria you can make code pass through */
        echo "Quality Gate passed!"
      }
    }
  
  
  
        }


        }
