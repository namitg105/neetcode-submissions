struct Node{
    int data;
     Node* next;


     Node(int val){
        data=val;
        next=nullptr;
     }
};



class LinkedList {
private:
Node* head;
public:
    LinkedList() {
head=nullptr;
    }

    int get(int index) {
Node* temp=head;
int count=0;

while(temp){
    if(count==index){
        return temp->data;
    }
    temp=temp->next;
    count++;
}

return -1;
    }

    void insertHead(int val) {
        Node* newNode=new Node(val);
        newNode->next=head;
        head=newNode;
    }
    
    void insertTail(int val) {
Node* newNode=new Node(val);
if(head==nullptr){
    head=newNode;
    return;
}
Node* temp=head;
while(temp->next){
temp=temp->next;
}
// newNode=temp;
temp->next=newNode;
    }
    bool remove(int index) {
        if(head==nullptr){
            return false;
        }

        if(index==0){
            Node* temp=head;
            head=head->next;
            delete temp;
            return true;
        }

        Node* curr=head;
        int count=0;

        while(curr&&count<index-1){
            curr=curr->next;
            count++;
        }
        if (curr == nullptr || curr->next == nullptr)
            return false;
        Node* delNode=curr->next;
       curr->next=delNode->next;
       delete delNode;

       return true;
    }

    vector<int> getValues() {
        vector<int> ans;
        Node*temp=head;

        while(temp){
            ans.push_back(temp->data);
            temp=temp->next;
        }

        return ans;
    }
};
