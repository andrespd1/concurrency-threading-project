import threading

def test():
    threading.Timer(5.0, test).start()
    print("Test thread")

test()