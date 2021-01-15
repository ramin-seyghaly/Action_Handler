package ramin.seyghaly.action_handler.core;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.telephony.PhoneNumberUtils;
import android.webkit.URLUtil;

import ramin.seyghaly.action_handler.interfaces.ActionObserver;
import ramin.seyghaly.action_handler.models.Action;
import ramin.seyghaly.action_handler.models.ActionCall;
import ramin.seyghaly.action_handler.models.ActionDeviceBrowser;
import ramin.seyghaly.action_handler.models.ActionSms;

import static ramin.seyghaly.action_handler.type.ActionType.CALL;

public class ActionHandler implements ActionObserver.Delegate {

    private final ActionObserver.Delegate delegate = this;
    private Activity activity;

    public ActionHandler(Activity activity){
        this.activity = activity;
    }

    public ActionObserver.Delegate getDelegate() {
        return delegate;
    }

    @Override
    public void onActionEvent(Action action) {
        if (action != null && action.getActionType() != null)
            switch (action.getActionType()){
                case DEVICE_BROWSER:
                    deviceBrowser(activity, (ActionDeviceBrowser)action);
                    break;
                case CALL:
                    call(activity, (ActionCall)action);
                    break;
                case SMS:
                    sms(activity, (ActionSms)action);
                    break;
            }
    }

    private void deviceBrowser(Activity activity, ActionDeviceBrowser actionDeviceBrowser){
        if (activity != null && actionDeviceBrowser != null && actionDeviceBrowser.getUrl() != null && URLUtil.isValidUrl(actionDeviceBrowser.getUrl())) {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(actionDeviceBrowser.getUrl()));
            activity.startActivity(i);
        }
    }

    private void call(Activity activity,ActionCall actionCall){
        if (activity != null && actionCall != null && actionCall.getNumber() != null && PhoneNumberUtils.isGlobalPhoneNumber(actionCall.getNumber())) {
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", actionCall.getNumber(), null));
            activity.startActivity(intent);
        }
    }

    private void sms(Activity activity,ActionSms actionSms){
        if (activity != null && actionSms != null && actionSms.getNumber() != null && PhoneNumberUtils.isGlobalPhoneNumber(actionSms.getNumber())) {
            Intent I =new Intent(Intent.ACTION_VIEW);
            I.setType("vnd.android-dir/mms-sms");
            I.setData(Uri.parse("smsto:"));
            String message = "";
            if (actionSms.getBody() != null){
                message = actionSms.getBody();
            }
            I.putExtra("address", new String (actionSms.getNumber()));
            I.putExtra("sms_body",message);
            activity.startActivity(I);
        }
    }

}
