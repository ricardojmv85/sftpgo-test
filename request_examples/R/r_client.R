install.packages("remotes")
remotes::install_github("stenevang/sftp")
install.packages("RCurl", type = "source")

connection <- sftp::sftp_connect(username="user1",
                           server="localhost",
                           password="user1",
                           protocol="sftp://",
                           port=22,
                           folder="")
sftp::sftp_upload(file='test_file.txt', 
                  fromfolder="../../",
                  sftp_connection = connection)

sftp::sftp_download(file='test_file.txt',
                    folder="",
                    sftp_connection = connection)
