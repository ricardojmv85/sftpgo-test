import paramiko

host,port = "localhost",22
transport = paramiko.Transport((host,port))

username,password = "user1","user1"
transport.connect(None,username,password)

sftp = paramiko.SFTPClient.from_transport(transport)

# # Download
filepath = "test_file.txt"
localpath = "testing.txt"
sftp.get(filepath,localpath)

# # Upload
filepath = "test_file.txt"
localpath = "../../test_file.txt"
sftp.put(localpath,filepath)

# List Directory
dir_path = ''
directory = sftp.listdir(dir_path)
print(directory)

sftp.close()
transport.close()