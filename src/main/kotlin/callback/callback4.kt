//package org.example.callback
//
//import java.nio.channels.SocketChannel
//
//fun main() {
//    val manager = GpcxManager()
//    manager.start()
//}
//interface ClientCallback {
//    fun onConnect()
//    fun onDisconnect()
//    fun onDataReceived(channel : SocketChannel, packet : ByteArray)
//}
//class NonBlockSocketClient(
//    private val ip: String,
//    private val port: Int,
//    private val callback: ClientCallback?
//) {
//    fun connect() {
//        // Simulate connection
//        println("Connecting to server at $ip:$port...")
//        callback?.onConnect()
//    }
//
//    fun disconnect() {
//        // Simulate disconnection
//        println("Disconnecting from server...")
//        callback?.onDisconnect()
//    }
//
//    fun sendData(data: String) {
//        // Simulate sending data and receiving a response
//        println("Sending data to server: $data")
//        callback?.onDataReceived(data.toByteArray())
//    }
//}
//
//class GpcxManager : ClientCallback {
//    private val MAX_BUFFER_SIZE = 1024 * 1024 * 8
//    private val TIMEOUT = 15000
//
//    private var socket: NonBlockSocketClient? = null
//
//    fun start() {
//        socket = NonBlockSocketClient("127.0.0.1", 8080, this).apply {
//            connect()
//        }
//    }
//
//    override fun onConnect() {
//        println("Connected to the server successfully.")
//        // You can send data or perform other operations upon successful connection
//        socket?.sendData("Hello, Server!")
//    }
//
//    override fun onDisconnect() {
//        println("Disconnected from the server.")
//    }
//
//    override fun onDataReceived(channel: SocketChannel, packet: ByteArray) {
//        TODO("Not yet implemented")
//    }
//
//    override fun onDataReceived(packet: ByteArray) {
//        println("Data received from the server: ${String(packet)}")
//        // Process received data here
//        socket?.disconnect()
//    }
//}
