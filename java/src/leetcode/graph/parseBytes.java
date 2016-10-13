package main.java.algorithms.graph;

/**
 * Created by xwang on 9/15/16.
 */
public class parseBytes {
    private int dataLen = 0;
    private int startPos = 0;

    private byte[] lenBuf = new byte[4];
    private int lenBufStart = 0;
    private byte[] dataBuf;
    private int dataBufStart = 0;

    public void parseByte(byte[] buf) {
//        while (startPos < buf.length) {
//
//            if (lenBufStart < 4) {
//                // to finish reading size
//                int bytesRead = readBytes(buf, startPos, dataBuf, dataBufStart);
//                if (bytesRead + lenBufStart < 4) {
//                    // not enough data, just return
//                    lenBufStart += bytesRead;
//                    startPos = 0;
//                    return; // end of while because all bytes has been processed
//                }
//                dataLen = convertBytes(lenBuf);
//                dataBuf = new byte[dataLen];
//                startPos += bytesRead;
//            }
//
//            if (dataLen > 0) {
//                int bytesRead = readBytes(buf, startPos, dataBuf, dataBufStart);
//                if (dataBufStart + bytesRead == dataLen) {
//                    // completed
//                    send(dataBuf);
//                    // prepare to read the next header.
//                    lenBufStart = 0;
//                    dataLen = 0;
//                    startPos += bytesRead;
//                    dataBuf = null;
//                } else {
//                    // not enough data
//                    dataBufStart += bytesRead;
//                    startPos = 0;
//                    return; // end of while;
//                }
//            }
//        }
    }
}
