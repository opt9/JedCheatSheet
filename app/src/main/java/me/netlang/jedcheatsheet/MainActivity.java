package me.netlang.jedcheatsheet;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private static final String NAME = "NAME";

    private SimpleExpandableListAdapter mAdapter;
    ExpandableListView simpleExpandableListView;
    // string arrays for group and child items
    private String groupItems[] = {
            "Control",
            "Meta",
            "Control-X",
            "Help",
    };
    private String[][] childItems = {
            // Control
            {
                    "Ctrl-a           Go to start of line",
                    "Ctrl-b           Move backward by character",
                    "Ctrl-d           Forward delete character",
                    "Ctrl-e           Go to end of line",
                    "Ctrl-f           Move forward by character",
                    "Ctrl-g           Abort out of things",
                    "Ctrl-i           Smart line indent",
                    "Ctrl-k           Kill to end of line",
                    "Ctrl-l           Put current line in center",
                    "Ctrl-n           Move forward by lines",
                    "Ctrl-o           Open up a blank line",
                    "Ctrl-p           Move backward by lines",
                    "Ctrl-r           Search backwards",
                    "Ctrl-s           Search forward",
                    "Ctrl-v           Move forward by pages",
                    "Ctrl-w           Kill region",
                    "Ctrl-y           Yank back from kill buffer",
                    "Ctrl-z           Suspend JED",
                    "Ctrl-_           Undo",
                    "Ctrl-@           Set mark",
            },
            // Meta
            {
                    "Alt-q            Format paragraph",
                    "Alt-v            Move backward by pages",
                    "Alt-w            Copy region to kill buffer",
                    "Alt-x            Execute JED command",
                    "Alt-y            Yank and pop",
                    "Alt-%            Query search and replace",
                    "Alt-<            Move to start of buffer",
                    "Alt->            Move to end of buffer",
                    "Alt-$            Invoke ispell",
            },
            // Control-X
            {
                    "Ctrl-x b         Switch to buffer",
                    "Ctrl-x d         Invoke directory editor",
                    "Ctrl-x f         Set fill column",
                    "Ctrl-x i         Insert file",
                    "Ctrl-x k         Kill buffer",
                    "Ctrl-x s         Save buffer",
                    "Ctrl-x u         Undo",
                    "Ctrl-x Ctrl-b    Display buffer list",
                    "Ctrl-x Ctrl-c    Exit JED",
                    "Ctrl-x Ctrl-f    Find file",
                    "Ctrl-x Ctrl-o    Collapse blank line to one",
                    "Ctrl-x Ctrl-a    Save current buffer",
                    "Ctrl-x Ctrl-s    Write buffer to file",
                    "Ctrl-x Ctrl-w    Save as filename",
            },
            // Help
            {
                    "Ctrl-h           Help",
                    "Ctrl-h a         Apropos",
                    "Ctrl-h f         Help on function",
                    "Ctrl-h h         Show basic key bindings",
                    "Ctrl-h k         Show key bindings",
                    "Ctrl-h i         Bring up Info browser",
                    "Ctrl-h m         Display Unix man page",
                    "Ctrl-h w         Show what key is bound to a command",
                    "Ctrl-h ?         Show menu",
            },
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //  initiate the expandable list view
        simpleExpandableListView = (ExpandableListView) findViewById(R.id.simpleExpandableListView);
        // create lists for group and child items
        List<Map<String, String>> groupData = new ArrayList<Map<String, String>>();
        List<List<Map<String, String>>> childData = new ArrayList<List<Map<String, String>>>();
        // add data in group and child list
        for (int i = 0; i < groupItems.length; i++) {
            Map<String, String> curGroupMap = new HashMap<String, String>();
            groupData.add(curGroupMap);
            curGroupMap.put(NAME, groupItems[i]);

            List<Map<String, String>> children = new ArrayList<Map<String, String>>();
            for (int j = 0; j < childItems[i].length; j++) {
                Map<String, String> curChildMap = new HashMap<String, String>();
                children.add(curChildMap);
                curChildMap.put(NAME, childItems[i][j]);
            }
            childData.add(children);
        }
        // define arrays for displaying data in Expandable list view
        String groupFrom[] = {NAME};
        int groupTo[] = {R.id.heading};
        String childFrom[] = {NAME};
        int childTo[] = {R.id.childItem};


        // Set up the adapter
        mAdapter = new SimpleExpandableListAdapter(this, groupData,
                R.layout.group_items,
                groupFrom, groupTo,
                childData, R.layout.child_items,
                childFrom, childTo);
        simpleExpandableListView.setAdapter(mAdapter);
    }
}
