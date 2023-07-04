// pipeline {
//     agent any
//     tools {
//         maven 'maven'
//     }
//     triggers {
//         pollSCM '* * * * *'
//     }
//     stages {
//         stage('Build') {
//             steps {
//                 sh 'mvn clean package'
//             }
//         }
//         stage('Transfer JAR to EC2') {
//             steps {
//                 script {
//                     def remoteDir = '/home/ubuntu/project/'  // Directory path on EC2 instance
//                     def privateKey = credentials('project')  // Jenkins credential for private key

//                     sshagent(credentials: 'project') {
//                         // Copy the JAR file to the remote directory
//                         sh "scp -i ${privateKey} target/*.jar ubuntu@16.171.117.156:${remoteDir}"
//                     }
//                 }
//             }
//         }
//     }
// }
// pipeline {
//     agent any
//     tools {
//         maven 'maven'
//     }
    
//     stages {
//         stage('Build') {
//             steps {
//                 // Your build steps here
//                 // For example:
//                 sh 'mvn clean install'
//             }
//         }
        
//         stage('Transfer JAR to EC2') {
//             steps {
//                 // Copy the JAR file to the EC2 instance
//                 withAWS(region: 'eu-north-1', credentials: 'aws-credentials') {
//                     sh 'scp -i ubuntu@16.170.55.198:/home/ubuntu/project/project-key.pem target/*.jar ubuntu@16.170.55.198:/home/ubuntu/project/'
//                 }
//             }
//         }
//     }
// }

pipeline {
    agent any
    tools {
        maven 'maven'
    }
    triggers {
        pollSCM '* * * * *'
    }

    stages {
        stage('Build') {
            steps {
                // Build your JAR file here
                // For example, using Maven
                sh 'mvn clean package'
            }
        }
        // stage('Transfer to EC2') {
        //     steps {
        //         // Transfer the JAR file to EC2 instance
        //         sh 'sudo scp target/*.jar ubuntu@16.170.55.198:/home/ubuntu/project/'
        //     }
        // }
        stage("Jar file transfer"){
            steps{
                sh """echo 'admin123' | sudo -S mv /var/lib/jenkins/workspace/cicd/target/examportal-0.0.1-SNAPSHOT.jar /home/ubuntu/project/"""
                sh """echo 'admin123' | sudo -S mv /home/ubuntu/project/examportal-0.0.1-SNAPSHOT.jar /home/ubuntu/project/examportal.jar"""
                sh """echo 'admin123' | sudo -S chmod 777 /home/ubuntu/project/examportal.jar"""
                // sh "admin123' | sudo -S ls"
            }
        }
        stage("Running jar file"){
            steps{
                // sh 'sudo java -jar /home/ubuntu/project/examportal.jar'
                // sh """echo 'admin123' | -S systemctl enable examportal"""
                // sh """echo 'admin123' | -S systemctl start examportal"""
                sh """sudo systemctl enable examportal"""
                sh """sudo systemctl start examportal"""
                sh """sudo systemctl restart examportal"""
                // sh 'sudo cd /home/ubuntu/project'
                // sh 'sudo java -jar /home/ubuntu/project/examportal.jar'
            }
        }
    }
}
