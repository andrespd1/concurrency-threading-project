import threading
import os

def execute():
    threading.Timer(5.0, execute).start()
    bashCmd = '''
                cd ..
                cd /Users/andres/Documents/Uniandes/infracomp/infracomp-caso1
                git remote update
                var="$(git status -uno)"
                if [[ $var =~ "nothing to commit" ]]; then
                    echo "Up-to-date"
                else
                    sudo systemctl restart manejador-comercios.service
                fi'''
    os.system(bashCmd)
execute()
