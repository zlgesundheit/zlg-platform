/*
 *  Copyright (c) 2019  Stefan Spiska (Vitasystems GmbH) and Hannover Medical School
 *  This file is part of Project EHRbase
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.ehrbase.client.openehrclient.defaultrestclient;

import org.ehrbase.client.openehrclient.OpenEhrClientConfig;
import org.ehrbase.client.templateprovider.FileBasedTemplateProvider;
import org.ehrbase.client.templateprovider.TestDataTemplateProvider;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.ehrbase.client.Ehrbaseadress;

public class DefaultRestClientTestHelper {

    public static DefaultRestClient setupDefaultRestClient() throws URISyntaxException {
        //TestDataTemplateProvider templateProvider = new TestDataTemplateProvider();
        Path templateFolder = Paths.get("C:\\Users\\richter122\\git-projects\\zlg-ehrbase\\Templates\\");
        FileBasedTemplateProvider cut = new FileBasedTemplateProvider(templateFolder);
        String baseadress = new Ehrbaseadress().getTESTENVGOE();
        DefaultRestClient client = new DefaultRestClient(new OpenEhrClientConfig(new URI(baseadress + "/ehrbase/rest/openehr/v1/")), cut);//templateProvider);
        //templateProvider.listTemplateIds().stream().forEach(t -> client.templateEndpoint().ensureExistence(t));
        return client;
    }
}