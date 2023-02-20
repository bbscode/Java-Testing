import subprocess
import threading
from time import sleep

def run_java_file(file_name):
    subprocess.run(['java', file_name])

# Compile the Java files
subprocess.run(['javac', 'Server.java'])
subprocess.run(['javac', 'Client.java'])

# Create threads to execute the Java files
thread1 = threading.Thread(target=run_java_file, args=('Server',))
thread2 = threading.Thread(target=run_java_file, args=('Client',))

# Start the threads
thread1.start()
sleep(0.1)
thread2.start()

# Wait for the threads to complete
thread1.join()
thread2.join()
