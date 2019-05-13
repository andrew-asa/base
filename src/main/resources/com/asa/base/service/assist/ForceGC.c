#include <stdio.h>
#include <stdlib.h>
#include <jvmti.h>
#include <jni_md.h>
#include "ForceGC.h"

typedef struct {
    jvmtiEnv* jvmti;
} GlobalAgentData;

static GlobalAgentData* gdata;


JNIEXPORT jint JNICALL Agent_OnAttach(JavaVM* jvm, char* options, void* reserved) {
    printf("Jvmti agent load successfully!\n");
    jvmtiEnv* jvmti = NULL;

    jint result = (*jvm)->GetEnv(jvm,(void**) &jvmti, JVMTI_VERSION_1_1);
    if (result != JNI_OK) {
        printf("ERROR: Unable to access JVMTI!\n");
    }

    gdata = (GlobalAgentData*) malloc(sizeof(GlobalAgentData));
    gdata->jvmti = jvmti;
    return JNI_OK;
}

JNIEXPORT jint JNICALL Java_com_asa_service_assist_JavaAssist_forceGC(JNIEnv* env, jclass thisClass) {
    jvmtiError error = (*(gdata->jvmti))->ForceGarbageCollection(gdata->jvmti);
    if (error == JVMTI_ERROR_NONE) {
       printf("Force garbage collection successfully!\n");
       return 0;
    } else {
       printf("Error occurred when force garbage collection!\n");
       return error;
    }
}