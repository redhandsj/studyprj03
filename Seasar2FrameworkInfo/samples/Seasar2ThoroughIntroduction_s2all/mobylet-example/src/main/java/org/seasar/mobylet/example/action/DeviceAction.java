package org.seasar.mobylet.example.action;

import javax.annotation.Resource;

import org.mobylet.core.Carrier;
import org.mobylet.core.Mobylet;
import org.mobylet.core.device.Device;
import org.seasar.struts.annotation.Execute;

/**
 * 端末のデバイス情報を取得するサンプルです。
 *
 * @author Naoki Takezoe
 */
public class DeviceAction {

	@Resource
	protected Mobylet mobylet;

	public Carrier carrier;
	public Device device;
	public String uid;
	public String guid;
	public boolean hasGps;

	@Execute(validator = false)
	public String index() {
		this.carrier = mobylet.getCarrier();
		if (carrier != Carrier.OTHER) {
			this.device = mobylet.getDevice();
			this.uid = mobylet.getUid();
			this.guid = mobylet.getGuid();
			if (device != null) {
				this.hasGps = device.hasGps();
			}
		}

		return "index.jsp";
	}

	@Execute(validator = false)
	public String gps(){
		return "gps.jsp";
	}
}
