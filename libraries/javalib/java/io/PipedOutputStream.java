package java.io;


/*
 * Java core library component.
 *
 * Copyright (c) 1997, 1998
 *      Transvirtual Technologies, Inc.  All rights reserved.
 *
 * See the file "license.terms" for information on usage and redistribution
 * of this file.
 */
public class PipedOutputStream
  extends OutputStream
{
	private PipedInputStream sink = null;

public PipedOutputStream() {
}

public PipedOutputStream(PipedInputStream snk) throws IOException {
	connect(snk);
}

public void close() throws IOException {
	if (sink != null) {
		sink.receivedLast();
	}
}

public void connect(PipedInputStream snk) throws IOException {
	if (sink != null) {
		throw new IOException("already connected");
	}
	sink = snk;
	sink.connect(this);
}

public void write(byte b[], int off, int len) throws IOException {
	if (sink == null) {
		throw new IOException();
	}
	super.write(b, off, len);
}

public void write(int b) throws IOException {
	if (sink == null) {
		throw new IOException();
	}
	sink.receive(b);
}
}
